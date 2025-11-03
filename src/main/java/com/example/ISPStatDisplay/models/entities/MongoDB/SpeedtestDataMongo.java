package com.example.ISPStatDisplay.models.entities.MongoDB;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "speedtest_data")
public class SpeedtestDataMongo {

    @Id
    private Long id;

    private Instant timestamp;

    private IdlePingMongo idlePingMongo;

    private DownloadTestMongo downloadTestMongo;

    private UploadTestMongo uploadTestMongo;

    private Float packetLoss;

    private String isp;

    @DBRef
    private ServerMongo serverMongo;

    public SpeedtestDataMongo() {}

    public SpeedtestDataMongo(Long id, Instant timestamp, IdlePingMongo idlePingMongo, DownloadTestMongo downloadTestMongo, UploadTestMongo uploadTestMongo, Float packetLoss, String isp, ServerMongo serverMongo) {
        this.id = id;
        this.timestamp = timestamp;
        this.idlePingMongo = idlePingMongo;
        this.downloadTestMongo = downloadTestMongo;
        this.uploadTestMongo = uploadTestMongo;
        this.packetLoss = packetLoss;
        this.isp = isp;
        this.serverMongo = serverMongo;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public IdlePingMongo getIdlePingMongo() {
        return idlePingMongo;
    }

    public void setIdlePingMongo(IdlePingMongo idlePingMongo) {
        this.idlePingMongo = idlePingMongo;
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

    public ServerMongo getServerMongo() {
        return serverMongo;
    }

    public void setServerMongo(ServerMongo serverMongo) {
        this.serverMongo = serverMongo;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public DownloadTestMongo getDownloadTestMongo() { return downloadTestMongo; }

    public void setDownloadTestMongo(DownloadTestMongo downloadTestMongo) { this.downloadTestMongo = downloadTestMongo;}

    public UploadTestMongo getUploadTestMongo() { return uploadTestMongo; }

    public void setUploadTestMongo(UploadTestMongo uploadTestMongo) { this.uploadTestMongo = uploadTestMongo; }
}
