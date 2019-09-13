package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * An identified part of the order. A product order is decomposed into one or more order items
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMFOrderItem {
    @NotNull(message = "This is mandatory field.")
    private BigInteger id;
    @JsonIgnore
    private BigInteger parentId;
    @NotNull(message = "This is mandatory field.")
    private String action;
    private String state = "Acknowledged";
    private Integer quantity;
    private String type;
    private String schemaLocation;
    @Valid
    private List<OrderTerm> itemTerm;
//    @NotNull(message = "This is mandatory field.")
    @Valid
    private List<OrderItemRelationship> orderItemRelationship;
    private List<TMFOrderItem> orderItems;

    @JsonDeserialize(as = ArrayList.class, contentAs = TMFOrderItem.class)
    @JsonProperty("orderItem")

    public List<TMFOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<TMFOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("@schemaLocation")
    public String getSchemaLocation() {
        return schemaLocation;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }


    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }
}

