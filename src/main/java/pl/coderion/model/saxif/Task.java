package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */

public class Task {

    private String taskId;

    private CommentList commentList;

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

    public CommentList getCommentList() {
        return commentList;
    }

    @XmlElement(name = "CommentList")
    public void setCommentList(CommentList commentList) {
        this.commentList = commentList;
    }
}
