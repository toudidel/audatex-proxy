package pl.coderion.model.saxif;

import javax.xml.bind.annotation.XmlElement;

/**
 * Copyright (C) Coderion sp. z o.o.
 */
public class GrandTotal {

    private String pnt;

    private String lbr;

    private String parts;

    private String nfodedu;

    private String rep;

    @XmlElement(name = "Pnt")
    public String getPnt() {
        return pnt;
    }

    public void setPnt(String pnt) {
        this.pnt = pnt;
    }

    @XmlElement(name = "Lbr")
    public String getLbr() {
        return lbr;
    }

    public void setLbr(String lbr) {
        this.lbr = lbr;
    }

    @XmlElement(name = "Parts")
    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    @XmlElement(name = "NFODedu")
    public String getNfodedu() {
        return nfodedu;
    }

    public void setNfodedu(String nfodedu) {
        this.nfodedu = nfodedu;
    }

    @XmlElement(name = "Rep")
    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }
}
