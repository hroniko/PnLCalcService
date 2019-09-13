package com.hroniko.pnl.entities.tmf.oe.reference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * BillingAccount reference.
 * A BillingAccount is a detailed description of a bill structure.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountRef {
    @NotNull(message = "This is mandatory field.")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger id;
    private String name;
    @JsonProperty("@type")
    private String referredType;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    @JsonProperty("href")
    public String getLink() {
        BigInteger id = getId();
        String href = null;
        if (id != null) {
            href = "/api/v1/billingManagement/billingAccount/" + id;
        }
        return href;
    }
}
