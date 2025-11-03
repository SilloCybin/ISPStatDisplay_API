package com.example.ISPStatDisplay.models.entities.MongoDB;

public class UploadTest {

    private Long bandwidth;
    private Long bytes;
    private Float elapsed;
    private UploadPing uploadPing;

    public UploadTest() {}

    public UploadTest(Long bandwidth, Long bytes, Float elapsed, UploadPing uploadPing) {
        this.bandwidth = bandwidth;
        this.bytes = bytes;
        this.elapsed = elapsed;
        this.uploadPing = uploadPing;
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

    public UploadPing getUploadPing() {
        return uploadPing;
    }

    public void setUploadPing(UploadPing downloadPingMongo) {
        this.uploadPing = downloadPingMongo;
    }
}
