package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Product reference.
 * Configure the product relationships & characteristics
 * (only configurable characteristics and necessary only if a non default value is selected)
 * and/or identify the product that needs to be modified/deleted.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BPIProduct {
    private String id;
    @NotNull(message = "This is mandatory field.")
    private String name;
    private String description;
    private String productSerialNumber;
    private String status;
    private List<BPIProductRelationship> productRelationship;
    private List<BPIProductCharacteristic> characteristic;

    private Boolean isBundle;
    private Boolean isCustomerVisible;
    private Date orderDate;
    private Date startDate;
    private Date terminationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BPIProductRelationship> getProductRelationship() {
        return productRelationship;
    }

    public void setProductRelationship(List<BPIProductRelationship> productRelationship) {
        this.productRelationship = productRelationship;
    }

    public List<BPIProductCharacteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<BPIProductCharacteristic> characteristic) {
        this.characteristic = characteristic;
    }


    public String getProductSerialNumber() {
        return productSerialNumber;
    }

    public void setProductSerialNumber(String productSerialNumber) {
        this.productSerialNumber = productSerialNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getBundle() {
        return isBundle;
    }

    public void setBundle(Boolean bundle) {
        isBundle = bundle;
    }

    public Boolean getCustomerVisible() {
        return isCustomerVisible;
    }

    public void setCustomerVisible(Boolean customerVisible) {
        isCustomerVisible = customerVisible;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getLink() {
        return null;
    }
}
