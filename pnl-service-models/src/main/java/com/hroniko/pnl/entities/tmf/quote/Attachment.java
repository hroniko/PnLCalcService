package com.hroniko.pnl.entities.tmf.quote;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigInteger;

/**
 * Complements the description of an element (for instance a product) through video, pictures...
 */
public class Attachment {
    /**
     * Unique identifier of the attachment
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger id;

    /**
     * A narrative text describing the content of the attachment
     */
    private String description;

    /**
     * Attachment type such as video, picture
     */
    private String attachmentType;

    /**
     * Uniform Resource Locator, is a web page address (a subset of URI)
     */
    private String url;

    /**
     * Indicates the base (class) type of the attachment
     */
    private String baseType;

    /**
     * Indicates the (class) type of the attachment
     */
    private String type;

    /**
     * Link to schema describing this REST resource
     */
    private String schemaLocation;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("type")
    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("@baseType")
    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
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

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    @JsonProperty("href")
    public String getLink() {
        return null;
    }
}
