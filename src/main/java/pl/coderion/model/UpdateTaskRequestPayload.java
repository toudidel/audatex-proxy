package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload", namespace = "http://serviceinterface_v1.b2b.audatex.com")
public class UpdateTaskRequestPayload {

    private Task task;

    @XmlElement(name = "Task")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
