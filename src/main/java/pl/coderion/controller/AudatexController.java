package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.B2BRequest;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
import com.audatex.b2b.serviceinterface_v1.TaskServicePort;
import com.sun.org.apache.xerces.internal.dom.ElementImpl;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import pl.coderion.config.AppConfig;
import pl.coderion.model.*;
import pl.coderion.util.ParameterUtil;
import pl.coderion.util.ResponseUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.dom.DOMResult;

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

    @RequestMapping("/ping")
    public PingResponse ping() {
        logger.info("> ping");

        PingResponse pingResponse = new PingResponse();

        B2BResponse response = taskServicePort.ping(new B2BRequest());

        logger.info("Host name: " + response.getHostName());
        logger.info("Return code: " + response.getReturnCode());
        logger.info("Timestampe: " + response.getTimestamp());
        logger.info("Login ID: " + response.getLoginId());

        pingResponse.setHostName(response.getHostName());
        pingResponse.setReturnCode(response.getReturnCode());
        pingResponse.setTimestamp(response.getTimestamp().toGregorianCalendar().getTime());

        ResponseUtil.parseMessages(pingResponse, response.getMessage());

        return pingResponse;
    }

    @RequestMapping("/findTasks")
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

    @RequestMapping("/updateTask")
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

        DOMResult payload = new DOMResult();
        UpdateTaskRequestPayload updateTaskRequestPayload = new UpdateTaskRequestPayload();
        CommentList commentList = new CommentList();
        commentList.getComments().add(new Comment(author, orgId, text, commentType, category));
        Task task = new Task(taskId, caseId, commentList);
        updateTaskRequestPayload.setTask(task);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(UpdateTaskRequestPayload.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(updateTaskRequestPayload, payload);
        } catch (JAXBException e) {
            logger.error("An error occured during marshalling payload", e);
        }

        request.setPayload(payload);

        B2BResponse response = taskServicePort.updateTask(request);

        ResponseUtil.parseMessages(updateTaskResponse, response.getMessage());

        return updateTaskResponse;
    }
}
