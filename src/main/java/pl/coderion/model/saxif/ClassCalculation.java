package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ClassCalculation {

    private ClassInput classInput;

    private ClassResult classResult;

    private AttachmentBinaryList attachmentBinaryList;

    @XmlElement(name = "CLASSInput")
    public ClassInput getClassInput() {
        return classInput;
    }

    public void setClassInput(ClassInput classInput) {
        this.classInput = classInput;
    }

    @XmlElement(name = "CLASSResult")
    public ClassResult getClassResult() {
        return classResult;
    }

    public void setClassResult(ClassResult classResult) {
        this.classResult = classResult;
    }

    @XmlElement(name = "AttachmentBinaryList")
    public AttachmentBinaryList getAttachmentBinaryList() {
        return attachmentBinaryList;
    }

    public void setAttachmentBinaryList(AttachmentBinaryList attachmentBinaryList) {
        this.attachmentBinaryList = attachmentBinaryList;
    }
}
