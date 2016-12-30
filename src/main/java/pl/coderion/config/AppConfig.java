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

    @Getter @Setter private String wsdl;

    @Getter @Setter private String loginId;

    @Getter @Setter private String password;

    @Getter @Setter private String fieldsToReturn;

    @Getter @Setter private String onlyMarkedTasks;

    @Getter @Setter private String returnPayloadAsXML;
}
