package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class FinalCalc {

    private GrandTotal grandTotal;

    @XmlElement(name = "GrandTotal")
    public GrandTotal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(GrandTotal grandTotal) {
        this.grandTotal = grandTotal;
    }
}
