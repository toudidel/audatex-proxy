package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.B2BMessage;
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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;

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
        pingResponse.setMessages(new ArrayList<>());

        B2BResponse response = taskServicePort.ping(new B2BRequest());

        logger.info("Host name: " + response.getHostName());
        logger.info("Return code: " + response.getReturnCode());
        logger.info("Timestampe: " + response.getTimestamp());
        logger.info("Login ID: " + response.getLoginId());

        pingResponse.setHostName(response.getHostName());
        pingResponse.setReturnCode(response.getReturnCode());
        pingResponse.setTimestamp(response.getTimestamp().toGregorianCalendar().getTime());

        for (B2BMessage message : response.getMessage()) {
            logger.info(String.format("Message: %s (%s) - %s", message.getMessageCode(), message.getSeverity(), message.getText()));

            PingResponseMessage pingResponseMessage = new PingResponseMessage();
            pingResponseMessage.setMessageCode(message.getMessageCode());
            pingResponseMessage.setSeverity(message.getSeverity());
            pingResponseMessage.setText(message.getText());

            pingResponse.getMessages().add(pingResponseMessage);
        }

        return pingResponse;
    }

    @RequestMapping("/findTasks")
    public FindTasksResponse findTasks(@RequestParam(value = "claimNumber") String claimNumber) {
        logger.info("> findTasks: claimNumber=" + claimNumber);

        FindTasksResponse findTasksResponse = new FindTasksResponse();

        B2BRequest findTasksRequest = new B2BRequest();

        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.LOGIN_ID, appConfig.getLoginId()));
        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.PASSWORD, appConfig.getPassword()));
        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.FIELDS_TO_RETURN, appConfig.getFieldsToReturn()));
        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.ONLY_MARKED_TASKS, appConfig.getOnlyMarkedTasks()));
        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.FILTER_CLAIM_NUMBER, claimNumber));
        findTasksRequest.getParameter().add(ParameterUtil.newParameter(Parameters.RETURN_PAYLOAD_AS_XML, appConfig.getReturnPayloadAsXML()));

        B2BResponse response = taskServicePort.findTasks(findTasksRequest);

        if (response.getPayload() instanceof ElementImpl) {
            ElementImpl elementNS = (ElementImpl) response.getPayload();
            Document document = elementNS.getOwnerDocument();

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(FindTasksPayload.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                FindTasksPayload findTasksPayload = (FindTasksPayload) jaxbUnmarshaller.unmarshal(document);
                findTasksResponse.setPayload(findTasksPayload);
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
}
