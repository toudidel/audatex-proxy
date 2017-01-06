package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.AttachmentServicePort;
import com.audatex.b2b.serviceinterface_v1.B2BRequest;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
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
import pl.coderion.model.AttachmentBinaryListPayload;
import pl.coderion.model.BaseResponse;
import pl.coderion.model.Parameters;
import pl.coderion.util.MarshallingUtil;
import pl.coderion.util.ParameterUtil;
import pl.coderion.util.ResponseUtil;
import pl.coderion.util.SOAPLoggingHandler;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@RestController
public class AttachmentServiceController {

    Logger logger = LoggerFactory.getLogger(getClass());

    //<editor-fold desc="@Autowired">
    @Autowired
    @Qualifier(value = "attachmentServicePort")
    AttachmentServicePort attachmentServicePort;

    @Autowired
    AppConfig appConfig;
    //</editor-fold>

    @ApiOperation(value = "Add attachment to task", notes = "Uploads attachments and adds them to an existing task")
    @RequestMapping(method = {RequestMethod.POST}, path = "/addAttachmentsToTaskRequest")
    public BaseResponse addAttachmentsToTaskRequest(@RequestParam(value = "login") String login,
                                                    @RequestParam(value = "password") String password,
                                                    @RequestParam(value = "taskId") String taskId,
                                                    @RequestParam(value = "processAsUser") String processAsUser,
                                                    @RequestParam(value = "fileName") String fileName,
                                                    @RequestParam(value = "fileExtension") String fileExtension,
                                                    @RequestParam(value = "category") String category,
                                                    @RequestParam(value = "attachment") String attachment) {

        BaseResponse baseResponse = new BaseResponse();
        B2BRequest request = new B2BRequest();

        request.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, login));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, password));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.TASK_ID, taskId));
        request.getParameter().add(ParameterUtil.newParameter(Parameters.PROCESS_AS_USER, processAsUser));

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
}
