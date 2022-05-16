package com.athena.calendar;

import java.util.Date;

public class Event {
    private String eventName;
    private Date eventDateTime;
    private boolean recurring;
    private String frequency;

    public Event(String eventName, Date eventDateTime, boolean recurring, String frequency) {
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.recurring = recurring;
        this.frequency = frequency;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

}
