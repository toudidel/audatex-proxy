package pl.coderion.config;

import com.audatex.b2b.serviceinterface_v1.AttachmentService;
import com.audatex.b2b.serviceinterface_v1.AttachmentServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@Configuration
public class AttachmentServiceConfiguration {

    @Autowired
    AppConfig appConfig;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = "attachmentServicePort")
    AttachmentServicePort attachmentServicePort() throws MalformedURLException {
        AttachmentService attachmentService = new AttachmentService(new URL(appConfig.getAttachmentServiceWsdl()));
        logger.info("AttachmentService client initialized");
        return attachmentService.getAttachmentServicePort();
    }
}
