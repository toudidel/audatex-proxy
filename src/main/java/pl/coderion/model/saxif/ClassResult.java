package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ClassResult {

    private ClassXml classXml;

    @XmlElement(name = "CLASSXml")
    public ClassXml getClassXml() {
        return classXml;
    }

    public void setClassXml(ClassXml classXml) {
        this.classXml = classXml;
    }
}
