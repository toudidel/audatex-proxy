package pl.coderion.model;

import pl.coderion.model.saxif.Source;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class AttachmentBinary {

    private String fileName;

    private String fileExtension;

    private Source source;

    private String category;

    public AttachmentBinary() {
    }

    public AttachmentBinary(String fileName, String fileExtension, String category, String attachment) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.category = category;
        this.source = new Source(attachment);
    }

    @XmlElement(name = "FileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @XmlElement(name = "FileExtension")
    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @XmlElement(name = "Source")
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @XmlElement(name = "Category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
