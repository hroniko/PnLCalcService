package com.hroniko.pnl.entities.catalog;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document("opexes")
@HashIndex(fields = { "name", "offeringId" }, unique = true)
public class Opex {

    @Id
    private String id;

    private String name;
    private String description;
    private BigInteger offeringId;
    private String offeringName;
    private Double value;

    private List<Opex> opexList;

    public Opex() {
    }

    public String getId() {
        return id;
    }

    public Opex setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Opex setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public Opex setName(String name) {
        this.name = name;
        return this;
    }

    public BigInteger getOfferingId() {
        return offeringId;
    }

    public Opex setOfferingId(BigInteger offeringId) {
        this.offeringId = offeringId;
        return this;
    }

    public String getOfferingName() {
        return offeringName;
    }

    public Opex setOfferingName(String offeringName) {
        this.offeringName = offeringName;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Opex setValue(Double value) {
        this.value = value;
        return this;
    }

    public List<Opex> getOpexList() {
        return opexList;
    }

    public Opex setOpexList(List<Opex> opexList) {
        this.opexList = opexList;
        return this;
    }

    public Opex addCapex(Opex capex){
        if (opexList == null) {
            opexList = new ArrayList<>();
        }
        if (!opexList.contains(capex))
            opexList.add(capex);
        return this;
    }

    public Opex addCapexs(Opex... capexs){
        for (Opex capex : capexs){
            addCapex(capex);
        }
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("offeringId", offeringId)
                .append("offeringName", offeringName)
                .append("value", value)
                .append("capexList", opexList)
                .toString();
    }
}
