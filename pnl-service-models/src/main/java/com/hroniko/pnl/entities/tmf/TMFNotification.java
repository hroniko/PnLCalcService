package com.hroniko.pnl.entities.tmf;


public class TMFNotification {
    private CustomerEventType eventType;

    private TMFCustomerEvent event;

    public CustomerEventType getEventType() {
        return eventType;
    }

    public void setEventType(CustomerEventType eventType) {
        this.eventType = eventType;
    }

    public TMFCustomerEvent getEvent() {
        return event;
    }

    public void setEvent(TMFCustomerEvent event) {
        this.event = event;
    }
}


