package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class AttachmentBinary {

    private String fileExtension;

    private Source source;

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
}
