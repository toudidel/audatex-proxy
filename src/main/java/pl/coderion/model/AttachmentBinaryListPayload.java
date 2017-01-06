package pl.coderion.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
@XmlRootElement(name = "payload")
public class AttachmentBinaryListPayload {

    private AttachmentBinaryList attachmentBinaryList;

    public AttachmentBinaryListPayload() {
    }

    public AttachmentBinaryListPayload(String fileName, String fileExtension, String category, String attachment) {
        this.attachmentBinaryList = new AttachmentBinaryList(fileName, fileExtension, category, attachment);
    }

    @XmlElement(name = "AttachmentBinaryList")
    public AttachmentBinaryList getAttachmentBinaryList() {
        return attachmentBinaryList;
    }

    public void setAttachmentBinaryList(AttachmentBinaryList attachmentBinaryList) {
        this.attachmentBinaryList = attachmentBinaryList;
    }
}
