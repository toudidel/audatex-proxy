package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ClassResult {

    private ClassXml classXml;

    private String calculationDateTime;

    private String userId;

    @XmlElement(name = "CLASSXml")
    public ClassXml getClassXml() {
        return classXml;
    }

    public void setClassXml(ClassXml classXml) {
        this.classXml = classXml;
    }

    @XmlElement(name = "CalculationDateTime")
    public String getCalculationDateTime() {
        return calculationDateTime;
    }

    public void setCalculationDateTime(String calculationDateTime) {
        this.calculationDateTime = calculationDateTime;
    }

    @XmlElement(name = "UserId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
