package com.example.ISPStatDisplay.models;

import java.util.Date;

public class MetricPoint {

    private Date timestamp;
    private Number value;

    public MetricPoint(Date timestamp, Number value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    /*public void setValue(Long value) {
        this.value = value;
    }*/
}
