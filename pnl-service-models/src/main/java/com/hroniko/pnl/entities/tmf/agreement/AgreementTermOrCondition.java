package com.hroniko.pnl.entities.tmf.agreement;

import java.util.Date;

public class AgreementTermOrCondition {

    private String Id;

    private String href;

    private Date validFor;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Date getValidFor() {
        return validFor;
    }

    public void setValidFor(Date validFor) {
        this.validFor = validFor;
    }
}
