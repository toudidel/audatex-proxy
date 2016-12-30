package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class TaskProxyList {

    private TaskProxy taskProxy;

    @XmlElement(name = "TaskProxy")
    public TaskProxy getTaskProxy() {
        return taskProxy;
    }

    public void setTaskProxy(TaskProxy taskProxy) {
        this.taskProxy = taskProxy;
    }
}
