package com.hroniko.pnl.entities.tmf.oe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * A Product Order is a type of order which can be used to place
 * an order between a customer and a service provider or between a service provider and a partner and vice versa.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMFProductOrder implements TMFOrderItemsContainer {
    private BigInteger id;
    private String externalId;
    private String description;
    private String priority = "4 (lowest)";
    private String category = "Uncategorized";
    private String state = "Acknowledged";
    private Date orderDate;
    private Date completionDate;
    private Date requestedStartDate;
    private Date requestedCompletionDate;
    private Date expectedCompletionDate;
    private String notificationContact;
    private String type;
    private String schemaLocation;
    private String baseType;
    @Valid
    private List<TMFChannel> channel;
    @NotNull(message = "This is mandatory field.")
    @Valid
    private List<TMFOrderItem> orderItems;

    @JsonProperty("orderItem")
    @SuppressWarnings("PMD.LooseCoupling")
    @Override
    public List<TMFOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<TMFOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public TMFProductOrder() {
    }

    public TMFProductOrder(BigInteger id) {
        this.id = id;
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

    @JsonProperty("@baseType")
    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public BigInteger getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getRequestedStartDate() {
        return requestedStartDate;
    }

    public void setRequestedStartDate(Date requestedStartDate) {
        this.requestedStartDate = requestedStartDate;
    }

    public Date getRequestedCompletionDate() {
        return requestedCompletionDate;
    }

    public void setRequestedCompletionDate(Date requestedCompletionDate) {
        this.requestedCompletionDate = requestedCompletionDate;
    }

    public Date getExpectedCompletionDate() {
        return expectedCompletionDate;
    }

    public void setExpectedCompletionDate(Date expectedCompletionDate) {
        this.expectedCompletionDate = expectedCompletionDate;
    }

    public String getNotificationContact() {
        return notificationContact;
    }

    public void setNotificationContact(String notificationContact) {
        this.notificationContact = notificationContact;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }


    public List<TMFChannel> getChannel() {
        return channel;
    }

    public void setChannel(List<TMFChannel> channel) {
        this.channel = channel;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @JsonProperty("href")
    public String getLink() {
        return "/api/v1/tmf/productOrder/" + getId();
    }
}
