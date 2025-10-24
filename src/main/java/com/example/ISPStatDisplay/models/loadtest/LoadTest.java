package com.example.ISPStatDisplay.models.loadtest;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class LoadTest {

    private Long bandwidth;
    private Long bytes;
    private Float elapsed;

    public LoadTest() {}

    public LoadTest(Long bandwidth, Long bytes, Float elapsed) {
        this.bandwidth = bandwidth;
        this.bytes = bytes;
        this.elapsed = elapsed;
    }

    public Long getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    public Float getElapsed() {
        return elapsed;
    }

    public void setElapsed(Float elapsed) {
        this.elapsed = elapsed;
    }
}
