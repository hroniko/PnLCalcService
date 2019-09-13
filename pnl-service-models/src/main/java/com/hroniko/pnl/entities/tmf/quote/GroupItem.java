package com.hroniko.pnl.entities.tmf.quote;

import java.util.List;

public class GroupItem {

    private String id;
    private String name;
    private List<QuotePrice> totalPricesByGroup;

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

    public List<QuotePrice> getTotalPricesByGroup() {
        return totalPricesByGroup;
    }

    public void setTotalPricesByGroup(List<QuotePrice> totalPricesByGroup) {
        this.totalPricesByGroup = totalPricesByGroup;
    }
}
