package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class Source {

    private String attachment;

    public Source() {
    }

    public Source(String attachment) {
        this.attachment = attachment;
    }

    @XmlElement(name = "Attachment")
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
