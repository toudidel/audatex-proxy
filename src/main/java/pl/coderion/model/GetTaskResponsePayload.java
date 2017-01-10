package pl.coderion.model;

import pl.coderion.model.saxif.Task;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload", namespace = Namespaces.SERVICE_INTERACE)
public class GetTaskResponsePayload {

    private Task task;

    @XmlElement(name = "Task", namespace = Namespaces.SAXIF)
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
