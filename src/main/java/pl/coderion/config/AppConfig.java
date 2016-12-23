package pl.coderion.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@ConfigurationProperties(prefix = "application")
@Configuration
public class AppConfig {

    @Getter @Setter private String wsdl;
}
