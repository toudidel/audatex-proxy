package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload", namespace = "http://serviceinterface_v1.b2b.audatex.com")
public class FindTasksResponsePayload {

    private TaskProxyList taskProxyList;

    @XmlElement(name = "TaskProxyList", namespace = "http://www.audatex.com/SAXIF")
    public TaskProxyList getTaskProxyList() {
        return taskProxyList;
    }

    public void setTaskProxyList(TaskProxyList taskProxyList) {
        this.taskProxyList = taskProxyList;
    }
}
