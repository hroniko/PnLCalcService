package com.hroniko.pnl.entities.tmf;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TMFAccount extends TMFBase {
    @JsonProperty("href")
    public String getLink() {
        return "/api/v1/customerManagement/customerAccount/" + getId();
    }
}
