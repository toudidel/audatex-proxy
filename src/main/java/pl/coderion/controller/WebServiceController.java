package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.AttachmentServicePort;
import com.audatex.b2b.serviceinterface_v1.B2BRequest;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
import com.audatex.b2b.serviceinterface_v1.TaskServicePort;
import com.sun.org.apache.xerces.internal.dom.ElementImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import pl.coderion.util.MarshallingUtil;
import pl.coderion.util.ParameterUtil;
import pl.coderion.util.ResponseUtil;
import pl.coderion.util.SOAPLoggingHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@RestController
public class WebServiceController {

    Logger logger = LoggerFactory.getLogger(getClass());

    //<editor-fold desc="@Autowired">
    @Autowired
    AppConfig appConfig;

    @Autowired
    @Qualifier(value = "taskServicePort")
    TaskServicePort taskServicePort;

    @Autowired
    @Qualifier(value = "attachmentServicePort")
    AttachmentServicePort attachmentServicePort;
    //</editor-fold>

    @ApiOperation(value = "Test connection", notes = "Does nothing else than returning a fixed response. This can be used to test the connection to and the SOAP request handling of the AudaNet server. No user credentials need to be specified for this operation")
    @RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, path = "/ping")
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
    public FindTasksResponse findTasks(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "claimNumber") String claimNumber) {

        FindTasksResponse findTasksResponse = new FindTasksResponse();

        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, login));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, password));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.FIELDS_TO_RETURN, ConstantValues.TASK_FIELDS_TO_RETURN));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.ONLY_MARKED_TASKS, Boolean.FALSE.toString()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.FILTER_CLAIM_NUMBER, claimNumber));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.RETURN_PAYLOAD_AS_XML, Boolean.TRUE.toString()));

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
            logger.info(String.format("> findTasks for %s: %s", claimNumber, taskProxy.getTaskId()));
        } else {
            logger.warn(String.format("> findTasks for %s: TaskProxy is null", claimNumber));
        }

        return findTasksResponse;
    }

    @ApiOperation(value = "Update task", notes = "Updates an existing task with the data in the payload. The task to update is identified by the ItemId ('TaskId') and the CaseId in the payload task")
    @RequestMapping(method = RequestMethod.POST, path = "/updateTask")
    public UpdateTaskResponse updateTask(@RequestParam(value = "login") String login,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "claimNumber") String claimNumber,
                                         @RequestParam(value = "text") String text) {

        logger.info("> updateTask for " + claimNumber);

        String taskId = getTaskId(login, password, claimNumber);

        UpdateTaskResponse updateTaskResponse = new UpdateTaskResponse();
        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, login));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, password));

        CommentList commentList = new CommentList();
        commentList.getComments().add(new Comment(login, appConfig.getResponsibleOrganizationId(), text,
                ConstantValues.TASK_COMMENT_TYPE_PUBLIC));

        Task task = new Task(taskId, commentList);
        TaskPayload payload = new TaskPayload(task);

        Document document = MarshallingUtil.marshall(payload);
        request.setPayload(document.getDocumentElement());

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

    @ApiOperation(value = "Add attachment to task", notes = "Uploads attachments and adds them to an existing task")
    @RequestMapping(method = {RequestMethod.POST}, path = "/addAttachmentsToTaskRequest")
    public BaseResponse addAttachmentsToTaskRequest(@RequestParam(value = "login") String login,
                                                    @RequestParam(value = "password") String password,
                                                    @RequestParam(value = "claimNumber") String claimNumber,
                                                    @RequestParam(value = "fileName") String fileName,
                                                    @RequestParam(value = "fileExtension") String fileExtension,
                                                    @RequestParam(value = "category") String category,
                                                    @RequestParam(value = "attachment") String attachment) {

        logger.info("> addAttachmentsToTaskRequest for " + claimNumber);

        String taskId = getTaskId(login, password, claimNumber);

        BaseResponse baseResponse = new BaseResponse();
        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, login));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, password));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.TASK_ID, taskId));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PROCESS_AS_USER, login));

        AttachmentBinaryListPayload payload = new AttachmentBinaryListPayload(fileName, fileExtension, category, attachment);
        Document document = MarshallingUtil.marshall(payload);
        request.setPayload(document.getDocumentElement());

        // debug outbound and inbound messages
        if (Boolean.TRUE.equals(appConfig.getDebugWsMessages())) {
            Binding binding = ((BindingProvider) attachmentServicePort).getBinding();
            List<Handler> handlerChain = binding.getHandlerChain();
            handlerChain.add(new SOAPLoggingHandler());
            binding.setHandlerChain(handlerChain);
        }

        B2BResponse response = attachmentServicePort.addAttachmentsToTask(request);
        ResponseUtil.parseMessages(baseResponse, response);

        return baseResponse;
    }

    private String getTaskId(String login, String password, String claimNumber) {
        FindTasksResponse findTasksResponse = findTasks(login, password, claimNumber);

        if (findTasksResponse != null) {
            return findTasksResponse.getPayload().getTaskProxyList().getTaskProxy().getTaskId();
        }

        return null;
    }
}
