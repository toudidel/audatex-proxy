package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class CalculationList {

    private List<ClassCalculation> classCalculationList;

    public CalculationList() {
        this.classCalculationList = new ArrayList<>();
    }

    @XmlElement(name = "CLASSCalculation")
    public List<ClassCalculation> getClassCalculationList() {
        return classCalculationList;
    }

    public void setClassCalculationList(List<ClassCalculation> classCalculationList) {
        this.classCalculationList = classCalculationList;
    }
}
