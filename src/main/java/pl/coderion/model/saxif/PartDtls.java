package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class PartDtls {

    private List<PartDtl> partDtlList;

    public PartDtls() {
        this.partDtlList = new ArrayList<>();
    }

    @XmlElement(name = "PartDtl")
    public List<PartDtl> getPartDtlList() {
        return partDtlList;
    }

    public void setPartDtlList(List<PartDtl> partDtlList) {
        this.partDtlList = partDtlList;
    }
}
