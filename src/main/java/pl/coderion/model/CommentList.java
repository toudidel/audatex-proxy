package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;
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

    @XmlElement(name = "Comment", namespace = Namespaces.SAXIF)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
