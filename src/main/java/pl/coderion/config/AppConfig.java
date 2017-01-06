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

    @Getter @Setter private String taskServiceWsdl;

    @Getter @Setter private String attachmentServiceWsdl;

    @Getter @Setter private String responsibleOrganizationId;

    @Getter @Setter private Boolean debugWsMessages;
}
