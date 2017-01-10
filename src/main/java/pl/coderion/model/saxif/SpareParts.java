package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class SpareParts {

    private PartDtls partDtls;

    @XmlElement(name = "PartDtls")
    public PartDtls getPartDtls() {
        return partDtls;
    }

    public void setPartDtls(PartDtls partDtls) {
        this.partDtls = partDtls;
    }
}
