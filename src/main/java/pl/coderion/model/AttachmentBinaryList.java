package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class AttachmentBinaryList {

    private AttachmentBinary attachmentBinary;

    public AttachmentBinaryList() {
    }

    public AttachmentBinaryList(String fileName, String fileExtension, String category, String attachment) {
        this.attachmentBinary = new AttachmentBinary(fileName, fileExtension, category, attachment);
    }

    @XmlElement(name = "AttachmentBinary")
    public AttachmentBinary getAttachmentBinary() {
        return attachmentBinary;
    }

    public void setAttachmentBinary(AttachmentBinary attachmentBinary) {
        this.attachmentBinary = attachmentBinary;
    }
}
