package com.hroniko.pnl.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class PriceItem {
    private OrderItem orderItem;
    private Double totalMRC;
    private Double totalNRC;
    private Double quantity = 1.0;

    public PriceItem(Map<BigInteger, Map<BigInteger, List<String>>> orderItemCharacteristicValues, OrderItem orderItem) {
        this.totalMRC = toDoubleValue(orderItem.getRecurrentIndividualBasicPrice());
        this.totalNRC = toDoubleValue(orderItem.getOneTimeIndividualBasicPrice());
        this.orderItem = orderItem;
        if (orderItemCharacteristicValues.get(orderItem.getId()) != null
                && orderItemCharacteristicValues.get(orderItem.getId()).get(new BigInteger("9135613363113324872")) != null) {
        this.quantity =  Double.parseDouble(orderItemCharacteristicValues.get(orderItem.getId()).get(new BigInteger("9135613363113324872")).get(0));
    }
}

    public PriceItem(OrderItem orderItem, Map<BigInteger, AbstractCharacteristicValue<?>> characteristicValues) {
        this.totalMRC = toDoubleValue(orderItem.getRecurrentIndividualBasicPrice());
        this.totalNRC = toDoubleValue(orderItem.getOneTimeIndividualBasicPrice());
        this.orderItem = orderItem;
        if (characteristicValues.get(new BigInteger("9135613363113324872")) != null) {
            this.quantity =  Double.parseDouble(characteristicValues.get(new BigInteger("9135613363113324872")).getValue().toString());
        }
    }

    private Double toDoubleValue(BigDecimal sourceValue){
        sourceValue = sourceValue == null ? BigDecimal.ZERO : sourceValue;
        return sourceValue.doubleValue();
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public PriceItem setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
        return this;
    }

    public Double getTotalMRC() {
        return totalMRC;
    }

    public PriceItem setTotalMRC(Double totalMRC) {
        this.totalMRC = totalMRC;
        return this;
    }

    public Double getTotalNRC() {
        return totalNRC;
    }

    public PriceItem setTotalNRC(Double totalNRC) {
        this.totalNRC = totalNRC;
        return this;
    }

    public Double getQuantity() {
        return quantity;
    }

    public PriceItem setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "PriceItem{" +
                "orderItem=" + orderItem +
                ", totalMRC=" + totalMRC +
                ", totalNRC=" + totalNRC +
                '}';
    }
}
