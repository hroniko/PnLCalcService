package com.hroniko.pnl.entities.tmf;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TMFEngagedParty extends TMFBase{
    @JsonProperty("href")
    public String getLink() {
        return "link not specified";
    }
}
