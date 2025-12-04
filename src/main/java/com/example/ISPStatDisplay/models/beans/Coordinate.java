package com.example.ISPStatDisplay.models.beans;

import java.time.Instant;

public class Coordinate {

    private Instant timestamp;
    private Number value;

    public Coordinate(Instant timestamp, Number value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

}
