package com.example.ISPStatDisplay.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Averages {

    @Id
    private Integer id;

    private Long downloadBandwidth;

    private Long uploadBandwidth;

    private Float downloadPingLatency;

    private Float uploadPingLatency;

    private Float idlePingLatency;

    private Float downloadPingLow;

    private Float uploadPingLow;

    private Float idlePingLow;

    private Float downloadPingHigh;

    private Float uploadPingHigh;

    private Float idlePingHigh;

    private Float downloadPingJitter;

    private Float uploadPingJitter;

    private Float idlePingJitter;

    private Float packetLoss;

    public Averages() {}

    public Averages(Integer id,
                    Long downloadBandwidth,
                    Long uploadBandwidth,
                    Float downloadPingLatency,
                    Float uploadPingLatency,
                    Float idlePingLatency,
                    Float downloadPingLow,
                    Float uploadPingLow,
                    Float idlePingLow,
                    Float downloadPingHigh,
                    Float uploadPingHigh,
                    Float idlePingHigh,
                    Float downloadPingJitter,
                    Float uploadPingJitter,
                    Float idlePingJitter,
                    Float packetLoss) {
        this.id = id;
        this.downloadBandwidth = downloadBandwidth;
        this.uploadBandwidth = uploadBandwidth;
        this.downloadPingLatency = downloadPingLatency;
        this.uploadPingLatency = uploadPingLatency;
        this.idlePingLatency = idlePingLatency;
        this.downloadPingLow = downloadPingLow;
        this.uploadPingLow = uploadPingLow;
        this.idlePingLow = idlePingLow;
        this.downloadPingHigh = downloadPingHigh;
        this.uploadPingHigh = uploadPingHigh;
        this.idlePingHigh = idlePingHigh;
        this.downloadPingJitter = downloadPingJitter;
        this.uploadPingJitter = uploadPingJitter;
        this.idlePingJitter = idlePingJitter;
        this.packetLoss = packetLoss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDownloadBandwidth() {
        return downloadBandwidth;
    }

    public void setDownloadBandwidth(Long downloadBandwidth) {
        this.downloadBandwidth = downloadBandwidth;
    }

    public Long getUploadBandwidth() {
        return uploadBandwidth;
    }

    public void setUploadBandwidth(Long uploadBandwidth) {
        this.uploadBandwidth = uploadBandwidth;
    }

    public Float getDownloadPingLatency() {
        return downloadPingLatency;
    }

    public void setDownloadPingLatency(Float downloadPingLatency) {
        this.downloadPingLatency = downloadPingLatency;
    }

    public Float getUploadPingLatency() {
        return uploadPingLatency;
    }

    public void setUploadPingLatency(Float uploadPingLatency) {
        this.uploadPingLatency = uploadPingLatency;
    }

    public Float getIdlePingLatency() {
        return idlePingLatency;
    }

    public void setIdlePingLatency(Float idlePingLatency) {
        this.idlePingLatency = idlePingLatency;
    }

    public Float getDownloadPingLow() {
        return downloadPingLow;
    }

    public void setDownloadPingLow(Float downloadPingLow) {
        this.downloadPingLow = downloadPingLow;
    }

    public Float getUploadPingLow() {
        return uploadPingLow;
    }

    public void setUploadPingLow(Float uploadPingLow) {
        this.uploadPingLow = uploadPingLow;
    }

    public Float getIdlePingLow() {
        return idlePingLow;
    }

    public void setIdlePingLow(Float idlePingLow) {
        this.idlePingLow = idlePingLow;
    }

    public Float getDownloadPingHigh() {
        return downloadPingHigh;
    }

    public void setDownloadPingHigh(Float downloadPingHigh) {
        this.downloadPingHigh = downloadPingHigh;
    }

    public Float getUploadPingHigh() {
        return uploadPingHigh;
    }

    public void setUploadPingHigh(Float uploadPingHigh) {
        this.uploadPingHigh = uploadPingHigh;
    }

    public Float getIdlePingHigh() {
        return idlePingHigh;
    }

    public void setIdlePingHigh(Float idlePingHigh) {
        this.idlePingHigh = idlePingHigh;
    }

    public Float getDownloadPingJitter() {
        return downloadPingJitter;
    }

    public void setDownloadPingJitter(Float downloadPingJitter) {
        this.downloadPingJitter = downloadPingJitter;
    }

    public Float getUploadPingJitter() {
        return uploadPingJitter;
    }

    public void setUploadPingJitter(Float uploadPingJitter) {
        this.uploadPingJitter = uploadPingJitter;
    }

    public Float getIdlePingJitter() {
        return idlePingJitter;
    }

    public void setIdlePingJitter(Float idlePingJitter) {
        this.idlePingJitter = idlePingJitter;
    }

    public Float getPacketLoss() {
        return packetLoss;
    }

    public void setPacketLoss(Float packetLoss) {
        this.packetLoss = packetLoss;
    }
}
