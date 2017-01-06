package pl.coderion.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@ConfigurationProperties(prefix = "audatex")
@Configuration
public class AppConfig {

    @Getter @Setter private String taskServiceWsdl;         // url to TaskService WSDL

    @Getter @Setter private String attachmentServiceWsdl;   // url to AttachmentService WSDL

    @Getter @Setter private Boolean debugWsMessages;        // show outbound and inbound messages

    @Getter @Setter private String loginId;                 // login to WS

    @Getter @Setter private String password;                // password

    @Getter @Setter private String fieldsToReturn;          // set of fields need to be returned

    @Getter @Setter private String onlyMarkedTasks;

    @Getter @Setter private String returnPayloadAsXML;
}
