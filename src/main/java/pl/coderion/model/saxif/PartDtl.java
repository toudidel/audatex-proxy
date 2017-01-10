package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class PartDtl {

    private String gid;

    private String partDesc;

    private String partNo;

    @XmlElement(name = "GId")
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @XmlElement(name = "PartDesc")
    public String getPartDesc() {
        return partDesc;
    }

    public void setPartDesc(String partDesc) {
        this.partDesc = partDesc;
    }

    @XmlElement(name = "PartNo")
    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }
}
