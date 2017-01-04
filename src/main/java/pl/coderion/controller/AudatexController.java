package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.B2BRequest;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
import com.audatex.b2b.serviceinterface_v1.TaskServicePort;
import com.sun.org.apache.xerces.internal.dom.ElementImpl;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import pl.coderion.config.AppConfig;
import pl.coderion.model.*;
import pl.coderion.model.saxif.Comment;
import pl.coderion.model.saxif.CommentList;
import pl.coderion.model.saxif.Task;
import pl.coderion.model.ser.TaskPayload;
import pl.coderion.util.ParameterUtil;
import pl.coderion.util.ResponseUtil;
import pl.coderion.util.SOAPLoggingHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@RestController
@EnableEncryptableProperties
public class AudatexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier(value = "taskServicePort")
    TaskServicePort taskServicePort;

    @Autowired
    AppConfig appConfig;

    @Autowired
    Jaxb2Marshaller marshaller;

    @ApiOperation(value = "Test connection", notes = "Does nothing else than returning a fixed response. This can be used to test the connection to and the SOAP request handling of the AudaNet server. No user credentials need to be specified for this operation")
    @RequestMapping(method = RequestMethod.POST, path = "/ping")
    public PingResponse ping() {
        logger.info("> ping");

        PingResponse pingResponse = new PingResponse();

        B2BResponse response = taskServicePort.ping(new B2BRequest());

        logger.info("Host name: " + response.getHostName());
        logger.info("Return code: " + response.getReturnCode());
        logger.info("Timestampe: " + response.getTimestamp());
        logger.info("Login ID: " + response.getLoginId());

        ResponseUtil.parseMessages(pingResponse, response);

        return pingResponse;
    }

    @ApiOperation(value = "Find tasks", notes = "Returns a TaskProxyList with the tasks that the current user is allowed to see and match the filter criteria specified as parameters")
    @RequestMapping(method = {RequestMethod.POST}, path = "/findTasks")
    public FindTasksResponse findTasks(@RequestParam(value = "claimNumber") String claimNumber) {
        logger.info("> findTasks: claimNumber=" + claimNumber);

        FindTasksResponse findTasksResponse = new FindTasksResponse();

        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, appConfig.getLoginId()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, appConfig.getPassword()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.FIELDS_TO_RETURN, appConfig.getFieldsToReturn()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.ONLY_MARKED_TASKS, appConfig.getOnlyMarkedTasks()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.FILTER_CLAIM_NUMBER, claimNumber));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.RETURN_PAYLOAD_AS_XML, appConfig.getReturnPayloadAsXML()));

        B2BResponse response = taskServicePort.findTasks(request);

        if (response.getPayload() instanceof ElementImpl) {
            ElementImpl elementNS = (ElementImpl) response.getPayload();
            Document document = elementNS.getOwnerDocument();

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(FindTasksResponsePayload.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                FindTasksResponsePayload findTasksResponsePayload = (FindTasksResponsePayload) jaxbUnmarshaller.unmarshal(document);
                findTasksResponse.setPayload(findTasksResponsePayload);
            } catch (JAXBException e) {
                logger.error("An error occured during unmarshalling payload", e);
            }
        }

        TaskProxy taskProxy = findTasksResponse.getPayload().getTaskProxyList().getTaskProxy();

        if (taskProxy != null) {
            logger.info("TaskId: " + taskProxy.getTaskId());
            logger.info("CaseId: " + taskProxy.getCaseId());
        } else {
            logger.warn("TaskProxy is null");
        }

        return findTasksResponse;
    }

    @ApiOperation(value = "Update task", notes = "Updates an existing task with the data in the payload. The task to update is identified by the ItemId ('TaskId') and the CaseId in the payload task")
    @RequestMapping(method = RequestMethod.POST, path = "/updateTask")
    public UpdateTaskResponse updateTask(@RequestParam(value = "taskId") String taskId,
                                         @RequestParam(value = "caseId") String caseId,
                                         @RequestParam(value = "author") String author,
                                         @RequestParam(value = "orgId") String orgId,
                                         @RequestParam(value = "text") String text,
                                         @RequestParam(value = "commentType") String commentType,
                                         @RequestParam(value = "category") String category) {

        logger.info("> updateTask: taskId=" + taskId);

        UpdateTaskResponse updateTaskResponse = new UpdateTaskResponse();
        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, appConfig.getLoginId()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, appConfig.getPassword()));

        CommentList commentList = new CommentList();
        commentList.getComments().add(new Comment(author, orgId, text, commentType, category));
        Task task = new Task(caseId, taskId, commentList);
        TaskPayload taskPayload = new TaskPayload(task);

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();

            JAXBContext jaxbContext = JAXBContext.newInstance(TaskPayload.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(taskPayload, document);

            request.setPayload(document.getDocumentElement());

        } catch (JAXBException | ParserConfigurationException e) {
            logger.error("An error occured during marshalling payload", e);
        }

        // debug outbound and inbound messages
        if (Boolean.TRUE.equals(appConfig.getDebugWsMessages())) {
            Binding binding = ((BindingProvider) taskServicePort).getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            handlerChain.add(new SOAPLoggingHandler());
            binding.setHandlerChain(handlerChain);
        }

        B2BResponse response = taskServicePort.updateTask(request);
        ResponseUtil.parseMessages(updateTaskResponse, response);

        return updateTaskResponse;
    }
}
