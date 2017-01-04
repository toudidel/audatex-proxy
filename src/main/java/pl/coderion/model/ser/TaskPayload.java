package pl.coderion.model.ser;

import pl.coderion.model.Namespaces;
import pl.coderion.model.saxif.Task;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload")
public class TaskPayload {

    private Task task;

    public TaskPayload() {
    }

    public TaskPayload(Task task) {
        this.task = task;
    }

    @XmlElement(name = "Task", namespace = Namespaces.SAXIF)
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
