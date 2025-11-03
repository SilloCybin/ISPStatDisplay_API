package com.example.ISPStatDisplay.models.entities.MongoDB;

public class DownloadPing {

    private Float jitter;
    private Float latency;
    private Float low;
    private Float high;

    public DownloadPing(Float jitter, Float latency, Float low, Float high) {
        this.jitter = jitter;
        this.latency = latency;
        this.low = low;
        this.high = high;
    }

    public DownloadPing() {}

    public Float getJitter() {
        return jitter;
    }

    public void setJitter(Float jitter) {
        this.jitter = jitter;
    }

    public Float getLatency() {
        return latency;
    }

    public void setLatency(Float latency) {
        this.latency = latency;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

}
