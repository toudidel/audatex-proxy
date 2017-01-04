package pl.coderion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@Configuration
public class MarshallerConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        String[] packagesToScan = {"pl.coderion.model"};
        marshaller.setPackagesToScan(packagesToScan);
        return marshaller;
    }
}
