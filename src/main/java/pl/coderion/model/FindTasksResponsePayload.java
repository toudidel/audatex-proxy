package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload", namespace = Namespaces.SERVICE_INTERACE)
public class FindTasksResponsePayload {

    private TaskProxyList taskProxyList;

    @XmlElement(name = "TaskProxyList", namespace = Namespaces.SAXIF)
    public TaskProxyList getTaskProxyList() {
        return taskProxyList;
    }

    public void setTaskProxyList(TaskProxyList taskProxyList) {
        this.taskProxyList = taskProxyList;
    }
}
