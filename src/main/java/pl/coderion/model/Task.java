package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class Task {

    private String taskId;

    private String caseId;

    private CommentList commentList;

    public Task(String taskId, String caseId, CommentList commentList) {
        this.taskId = taskId;
        this.caseId = caseId;
        this.commentList = commentList;
    }

    @XmlElement(name = "ItemId")
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @XmlElement(name = "CaseId")
    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public CommentList getCommentList() {
        return commentList;
    }

    @XmlElement(name = "CommentList")
    public void setCommentList(CommentList commentList) {
        this.commentList = commentList;
    }
}
