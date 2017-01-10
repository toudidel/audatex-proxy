package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class CalcData {

    private SpareParts spareParts;

    @XmlElement(name = "SpareParts")
    public SpareParts getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }
}
