package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ClassCalculation {

    private ClassResult classResult;

    @XmlElement(name = "CLASSResult")
    public ClassResult getClassResult() {
        return classResult;
    }

    public void setClassResult(ClassResult classResult) {
        this.classResult = classResult;
    }
}
