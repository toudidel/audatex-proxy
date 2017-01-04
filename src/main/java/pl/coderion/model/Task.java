package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class Task {

    private String caseId;

    private String taskId;

    private CommentList commentList;

    public Task() {
    }

    public Task(String caseId, String taskId, CommentList commentList) {
        this.taskId = taskId;
        this.caseId = caseId;
        this.commentList = commentList;
    }

    @XmlElement(name = "CaseId", namespace = Namespaces.SAXIF)
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @XmlElement(name = "ItemId", namespace = Namespaces.SAXIF)
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public CommentList getCommentList() {
        return commentList;
    }

    @XmlElement(name = "CommentList", namespace = Namespaces.SAXIF)
    public void setCommentList(CommentList commentList) {
        this.commentList = commentList;
    }
}
