package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class Comment {

    private String author;

    private String responsibleOrganizationId;

    private String text;

    private String commentType;

    private String category;

    public Comment() {
    }

    public Comment(String author, String responsibleOrganizationId, String text, String commentType, String category) {
        this.author = author;
        this.responsibleOrganizationId = responsibleOrganizationId;
        this.text = text;
        this.commentType = commentType;
        this.category = category;
    }

    @XmlElement(name = "Author", namespace = Namespaces.SAXIF)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlElement(name = "ResponsibleOrganizationId", namespace = Namespaces.SAXIF)
    public String getResponsibleOrganizationId() {
        return responsibleOrganizationId;
    }

    public void setResponsibleOrganizationId(String responsibleOrganizationId) {
        this.responsibleOrganizationId = responsibleOrganizationId;
    }

    @XmlElement(name = "Text", namespace = Namespaces.SAXIF)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement(name = "CommentType", namespace = Namespaces.SAXIF)
    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @XmlElement(name = "Category", namespace = Namespaces.SAXIF)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
