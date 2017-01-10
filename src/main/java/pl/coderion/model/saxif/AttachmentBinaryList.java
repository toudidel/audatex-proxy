package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class AttachmentBinaryList {

    private List<AttachmentBinary> attachmentBinaryList;

    @XmlElement(name = "AttachmentBinary")
    public List<AttachmentBinary> getAttachmentBinaryList() {
        return attachmentBinaryList;
    }

    public void setAttachmentBinaryList(List<AttachmentBinary> attachmentBinaryList) {
        this.attachmentBinaryList = attachmentBinaryList;
    }
}
