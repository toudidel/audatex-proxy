package pl.coderion.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class CommentList {

    private List<Comment> comments;

    public CommentList() {
        this.comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
