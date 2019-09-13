package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * A related party defines party or party role linked to a specific entity.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedPartyRef {
    private String id;
    private String name;
    @JsonProperty("@type")
    private String referredType;
    @NotNull(message = "This is mandatory field.")
    private String role;
    private Date validFor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getValidFor() {
        return validFor;
    }

    public void setValidFor(Date validFor) {
        this.validFor = validFor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("href")
    public String getLink() {
        return null;
    }
}
