package pl.coderion.controller;

import com.audatex.b2b.serviceinterface_v1.B2BMessage;
import com.audatex.b2b.serviceinterface_v1.B2BRequest;
import com.audatex.b2b.serviceinterface_v1.B2BResponse;
import com.audatex.b2b.serviceinterface_v1.TaskServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderion.model.PingResponse;
import pl.coderion.model.PingResponseMessage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@RestController
public class AudatexController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier(value = "taskServicePort")
    TaskServicePort taskServicePort;

    @RequestMapping("/ping")
    public PingResponse ping() {
        logger.info("> Ping: " + new Date());

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
}
