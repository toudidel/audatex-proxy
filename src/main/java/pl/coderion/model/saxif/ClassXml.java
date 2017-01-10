package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class ClassXml {

    private CalcData calcData;

    @XmlElement(name = "CalcData")
    public CalcData getCalcData() {
        return calcData;
    }

    public void setCalcData(CalcData calcData) {
        this.calcData = calcData;
    }
}
