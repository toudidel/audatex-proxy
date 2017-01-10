package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class CalcData {

    private SpareParts spareParts;

    private FinalCalc finalCalc;

    @XmlElement(name = "SpareParts")
    public SpareParts getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }

    @XmlElement(name = "FinalCalc")
    public FinalCalc getFinalCalc() {
        return finalCalc;
    }

    public void setFinalCalc(FinalCalc finalCalc) {
        this.finalCalc = finalCalc;
    }
}
