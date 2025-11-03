package com.example.ISPStatDisplay.models.entities.MongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "speedtest_data")
public class SpeedtestData {

    @Id
    private Long id;

    private Instant timestamp;

    private IdlePing idlePing;

    private DownloadTest downloadTest;

    private UploadTest uploadTest;

    private Float packetLoss;

    private String isp;

    @DBRef
    private Server server;

    public SpeedtestData() {}

    public SpeedtestData(Long id, Instant timestamp, IdlePing idlePing, DownloadTest downloadTest, UploadTest uploadTest, Float packetLoss, String isp, Server server) {
        this.id = id;
        this.timestamp = timestamp;
        this.idlePing = idlePing;
        this.downloadTest = downloadTest;
        this.uploadTest = uploadTest;
        this.packetLoss = packetLoss;
        this.isp = isp;
        this.server = server;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public IdlePing getIdlePingMongo() {
        return idlePing;
    }

    public void setIdlePingMongo(IdlePing idlePing) {
        this.idlePing = idlePing;
    }

    public Float getPacketLoss() {
        return packetLoss;
    }

    public void setPacketLoss(Float packetLoss) {
        this.packetLoss = packetLoss;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public DownloadTest getDownloadTest() { return downloadTest; }

    public void setDownloadTest(DownloadTest downloadTest) { this.downloadTest = downloadTest;}

    public UploadTest getUploadTest() { return uploadTest; }

    public void setUploadTest(UploadTest uploadTest) { this.uploadTest = uploadTest; }
}
