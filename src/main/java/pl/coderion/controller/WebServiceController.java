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
import pl.coderion.model.saxif.AttachmentBinary;
import pl.coderion.model.saxif.*;
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
    public String findTasks(@RequestParam(value = "login") String login,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "claimNumber") String claimNumber) {

        FindTasksResponse findTasksResponse = findTasksFull(login, password, claimNumber);

        if (findTasksResponse != null && findTasksResponse.getPayload() != null) {
            return findTasksResponse.getPayload().getTaskProxyList().getTaskProxy().getTaskId();
        }

        return null;
    }

    @ApiOperation(value = "Find tasks", notes = "Returns a TaskProxyList with the tasks that the current user is allowed to see and match the filter criteria specified as parameters")
    @RequestMapping(method = {RequestMethod.POST}, path = "/findTasksFull")
    public FindTasksResponse findTasksFull(@RequestParam(value = "login") String login,
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

        if (findTasksResponse.getPayload() != null) {
            TaskProxy taskProxy = findTasksResponse.getPayload().getTaskProxyList().getTaskProxy();

            if (taskProxy != null) {
                logger.info(String.format("> findTasks for %s: %s", claimNumber, taskProxy.getTaskId()));
            } else {
                logger.warn(String.format("> findTasks for %s: TaskProxy is null", claimNumber));
            }
        } else {
            ResponseUtil.parseMessages(findTasksResponse, response);
        }

        return findTasksResponse;
    }

    @ApiOperation(value = "Update task", notes = "Updates an existing task with the data in the payload. The task to update is identified by the ItemId ('TaskId') and the CaseId in the payload task")
    @RequestMapping(method = RequestMethod.POST, path = "/updateTask")
    public String updateTask(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "claimNumber") String claimNumber,
                             @RequestParam(value = "text") String text) {

        UpdateTaskResponse response = updateTaskFull(login, password, claimNumber, text);
        Integer returnCode = response.getReturnCode();
        logger.info("ReturnCode: " + returnCode);
        return returnCode.toString();
    }

    @ApiOperation(value = "Update task", notes = "Updates an existing task with the data in the payload. The task to update is identified by the ItemId ('TaskId') and the CaseId in the payload task")
    @RequestMapping(method = RequestMethod.POST, path = "/updateTaskFull")
    public UpdateTaskResponse updateTaskFull(@RequestParam(value = "login") String login,
                                             @RequestParam(value = "password") String password,
                                             @RequestParam(value = "claimNumber") String claimNumber,
                                             @RequestParam(value = "text") String text) {

        logger.info("> updateTask for " + claimNumber);

        String taskId = findTasks(login, password, claimNumber);

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
    public String addAttachmentsToTaskRequest(@RequestParam(value = "login") String login,
                                                    @RequestParam(value = "password") String password,
                                                    @RequestParam(value = "claimNumber") String claimNumber,
                                                    @RequestParam(value = "fileName") String fileName,
                                                    @RequestParam(value = "fileExtension") String fileExtension,
                                                    @RequestParam(value = "category") String category,
                                                    @RequestParam(value = "attachment") String attachment) {

        BaseResponse response = addAttachmentsToTaskRequestFull(login, password, claimNumber, fileName, fileExtension,
                category, attachment);
        Integer returnCode = response.getReturnCode();
        logger.info("ReturnCode: " + returnCode);
        return returnCode.toString();
    }

    @ApiOperation(value = "Add attachment to task", notes = "Uploads attachments and adds them to an existing task")
    @RequestMapping(method = {RequestMethod.POST}, path = "/addAttachmentsToTaskRequestFull")
    public BaseResponse addAttachmentsToTaskRequestFull(@RequestParam(value = "login") String login,
                                                        @RequestParam(value = "password") String password,
                                                        @RequestParam(value = "claimNumber") String claimNumber,
                                                        @RequestParam(value = "fileName") String fileName,
                                                        @RequestParam(value = "fileExtension") String fileExtension,
                                                        @RequestParam(value = "category") String category,
                                                        @RequestParam(value = "attachment") String attachment) {

        logger.info("> addAttachmentsToTaskRequest for " + claimNumber);

        String taskId = findTasks(login, password, claimNumber);

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

    @ApiOperation(value = "Get task (parts)", notes = "Retrieves the task specified by the taskId parameter")
    @RequestMapping(method = {RequestMethod.POST}, path = "/getTaskParts")
    public String getTaskParts(@RequestParam(value = "login") String login,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "claimNumber") String claimNumber) {

        GetTaskResponse getTaskResponse = getTaskFull(login, password, claimNumber, GetTaskRequestTypeEnum.PARTS);
        GetTaskResponsePayload payload = getTaskResponse.getPayload();

        if (payload != null) {
            StringBuffer sb = new StringBuffer();

            for (ClassCalculation classCalculation : payload.getTask().getCalculationList().getClassCalculationList()) {
                for (PartDtl partDtl : classCalculation.getClassResult().getClassXml().getCalcData().getSpareParts().getPartDtls().getPartDtlList()) {
                    sb.append(String.format("%s %s %s%n", partDtl.getGid(), partDtl.getPartDesc(), partDtl.getPartNo()));
                }
            }

            return sb.toString();
        } else {
            Integer returnCode = getTaskResponse.getReturnCode();
            logger.info("ReturnCode: " + returnCode);
            return returnCode.toString();
        }
    }

    @ApiOperation(value = "Get task (valuation)", notes = "Retrieves the task specified by the taskId parameter")
    @RequestMapping(method = {RequestMethod.POST}, path = "/getTaskValuation")
    public String getTaskValuation(@RequestParam(value = "login") String login,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "claimNumber") String claimNumber) {

        GetTaskResponse getTaskResponse = getTaskFull(login, password, claimNumber, GetTaskRequestTypeEnum.VALUATION);
        GetTaskResponsePayload payload = getTaskResponse.getPayload();

        if (payload != null && payload.getTask() != null) {
            StringBuffer sb = new StringBuffer();

            for (ClassCalculation classCalculation : payload.getTask().getCalculationList().getClassCalculationList()) {
                GrandTotal grandTotal = classCalculation.getClassResult().getClassXml().getCalcData().getFinalCalc().getGrandTotal();
                sb.append(String.format("Pnt=%s%n", grandTotal.getPnt()));
                sb.append(String.format("Lbr=%s%n", grandTotal.getLbr()));
                sb.append(String.format("Parts=%s%n", grandTotal.getParts()));
                sb.append(String.format("NFODedu=%s%n", grandTotal.getNfodedu()));
                sb.append(String.format("Rep=%s%n", grandTotal.getRep()));
            }

            return sb.toString();
        } else {
            Integer returnCode = getTaskResponse.getReturnCode();
            logger.info("ReturnCode: " + returnCode);
            return returnCode.toString();
        }
    }

    @ApiOperation(value = "Get task (attachment)", notes = "Retrieves the task specified by the taskId parameter")
    @RequestMapping(method = {RequestMethod.POST}, path = "/getTaskAttachment")
    public String getTaskAttachment(@RequestParam(value = "login") String login,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "claimNumber") String claimNumber) {

        GetTaskResponse getTaskResponse = getTaskFull(login, password, claimNumber, GetTaskRequestTypeEnum.ATTACHMENT);
        GetTaskResponsePayload payload = getTaskResponse.getPayload();

        if (payload != null) {
            for (ClassCalculation classCalculation : payload.getTask().getCalculationList().getClassCalculationList()) {
                for (AttachmentBinary attachmentBinary : classCalculation.getAttachmentBinaryList().getAttachmentBinaryList()) {
                    if (!"pdf".equalsIgnoreCase(attachmentBinary.getFileExtension())) {
                        continue;
                    }

                    return attachmentBinary.getSource().getAttachment();
                }
            }
        } else {
            Integer returnCode = getTaskResponse.getReturnCode();
            logger.info("ReturnCode: " + returnCode);
            return returnCode.toString();
        }

        return null;
    }

    @ApiOperation(value = "Get task", notes = "Retrieves the task specified by the taskId parameter")
    @RequestMapping(method = {RequestMethod.POST}, path = "/getTaskFull")
    public GetTaskResponse getTaskFull(@RequestParam(value = "login") String login,
                                       @RequestParam(value = "password") String password,
                                       @RequestParam(value = "claimNumber") String claimNumber,
                                       GetTaskRequestTypeEnum requestType) {

        logger.info("> getTask for " + claimNumber);

        String taskId = findTasks(login, password, claimNumber);
        Boolean noAttachmentContent = !GetTaskRequestTypeEnum.ATTACHMENT.equals(requestType);

        GetTaskResponse getTaskResponse = new GetTaskResponse();
        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, login));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, password));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.TASK_ID, taskId));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.RETURN_PAYLOAD_AS_XML, Boolean.TRUE.toString()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.LAST_CHECKED_CALCULATION_ONLY, Boolean.TRUE.toString()));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.NO_ATTACHMENT_CONTENT, noAttachmentContent.toString()));

        B2BResponse response = taskServicePort.getTask(request);
        ResponseUtil.parseMessages(getTaskResponse, response);

        if (response.getPayload() instanceof ElementImpl) {
            ElementImpl elementNS = (ElementImpl) response.getPayload();
            Document document = elementNS.getOwnerDocument();

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(GetTaskResponsePayload.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                GetTaskResponsePayload getTaskResponsePayload = (GetTaskResponsePayload) jaxbUnmarshaller.unmarshal(document);
                getTaskResponse.setPayload(getTaskResponsePayload);
            } catch (JAXBException e) {
                logger.error("An error occured during unmarshalling payload", e);
            }
        }

        return getTaskResponse;
    }
}
