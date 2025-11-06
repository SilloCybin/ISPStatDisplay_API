package com.example.ISPStatDisplay.models.beans;

public class DownloadTest {

    private Long bandwidth;
    private Long bytes;
    private Float elapsed;
    private DownloadPing downloadPing;

    public DownloadTest() {}

    public DownloadTest(Long bandwidth, Long bytes, Float elapsed, DownloadPing downloadPing) {
        this.bandwidth = bandwidth;
        this.bytes = bytes;
        this.elapsed = elapsed;
        this.downloadPing = downloadPing;
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

    public DownloadPing getDownloadPing() {
        return downloadPing;
    }

    public void setDownloadPing(DownloadPing downloadPing) {
        this.downloadPing = downloadPing;
    }
}
