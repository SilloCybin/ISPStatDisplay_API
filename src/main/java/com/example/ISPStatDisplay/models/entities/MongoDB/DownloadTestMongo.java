package com.example.ISPStatDisplay.models.entities.MongoDB;

public class DownloadTestMongo {

    private Long bandwidth;
    private Long bytes;
    private Float elapsed;
    private DownloadPingMongo downloadPingMongo;

    public DownloadTestMongo() {}

    public DownloadTestMongo(Long bandwidth, Long bytes, Float elapsed, DownloadPingMongo downloadPingMongo) {
        this.bandwidth = bandwidth;
        this.bytes = bytes;
        this.elapsed = elapsed;
        this.downloadPingMongo = downloadPingMongo;
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

    public DownloadPingMongo getDownloadPingMongo() {
        return downloadPingMongo;
    }

    public void setDownloadPingMongo(DownloadPingMongo downloadPingMongo) {
        this.downloadPingMongo = downloadPingMongo;
    }
}
