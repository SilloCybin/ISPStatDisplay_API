package com.example.ISPStatDisplay.models.entities.MongoDB;

public class UploadTestMongo {

    private Long bandwidth;
    private Long bytes;
    private Float elapsed;
    private UploadPingMongo uploadPingMongo;

    public UploadTestMongo() {}

    public UploadTestMongo(Long bandwidth, Long bytes, Float elapsed, UploadPingMongo uploadPingMongo) {
        this.bandwidth = bandwidth;
        this.bytes = bytes;
        this.elapsed = elapsed;
        this.uploadPingMongo = uploadPingMongo;
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

    public UploadPingMongo getUploadPingMongo() {
        return uploadPingMongo;
    }

    public void setUploadPingMongo(UploadPingMongo downloadPingMongo) {
        this.uploadPingMongo = downloadPingMongo;
    }
}
