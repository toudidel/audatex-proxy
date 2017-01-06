package pl.coderion.config;

import com.audatex.b2b.serviceinterface_v1.TaskService;
import com.audatex.b2b.serviceinterface_v1.TaskServicePort;
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
public class TaskServiceConfiguration {

    @Autowired
    AppConfig appConfig;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = "taskServicePort")
    TaskServicePort taskServicePort() throws MalformedURLException {
        TaskService taskService = new TaskService(new URL(appConfig.getTaskServiceWsdl()));
        logger.info("TaskService client initialized");
        return taskService.getTaskServicePort();
    }
}
