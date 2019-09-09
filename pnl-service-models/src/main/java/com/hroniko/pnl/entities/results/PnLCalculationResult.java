package com.hroniko.pnl.entities.results;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class PnLCalculationResult {
    private String name;
    private String customerId;
    private String customerName;
    private List<String> locationIds;
    private List<PnLCalculationNodeResult> nodes;

    public PnLCalculationResult(){}

    public PnLCalculationResult(String name, String customerId, String customerName, List<String> locationIds) {
        this.name = name;
        this.customerId = customerId;
        this.customerName = customerName;
        this.locationIds = locationIds;
    }

    public PnLCalculationResult(String name, String customerId, String customerName, List<String> locationIds, List<PnLCalculationNodeResult> nodes) {
        this.name = name;
        this.customerId = customerId;
        this.customerName = customerName;
        this.locationIds = locationIds;
        this.nodes = nodes;
    }

    public String getName() {
        return name;
    }

    public PnLCalculationResult setName(String name) {
        this.name = name;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public PnLCalculationResult setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public PnLCalculationResult setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public List<String> getLocationIds() {
        return locationIds;
    }

    public PnLCalculationResult setLocationIds(List<String> locationIds) {
        this.locationIds = locationIds;
        return this;
    }

    public List<PnLCalculationNodeResult> getNodes() {
        return nodes;
    }

    public PnLCalculationResult setNodes(List<PnLCalculationNodeResult> nodes) {
        this.nodes = nodes;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .append("customerId", customerId)
                .append("customerName", customerName)
                .append("locationIds", locationIds)
                .append("nodes", nodes)
                .toString();
    }
}
