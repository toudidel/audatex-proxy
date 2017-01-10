package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */

public class Task {

    private String taskId;

    private CommentList commentList;

    private CalculationList calculationList;

    public Task() {
    }

    public Task(String taskId, CommentList commentList) {
        this.taskId = taskId;
        this.commentList = commentList;
    }

    @XmlElement(name = "ItemId")
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @XmlElement(name = "CommentList")
    public CommentList getCommentList() {
        return commentList;
    }

    public void setCommentList(CommentList commentList) {
        this.commentList = commentList;
    }

    @XmlElement(name = "CalculationList")
    public CalculationList getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(CalculationList calculationList) {
        this.calculationList = calculationList;
    }
}
