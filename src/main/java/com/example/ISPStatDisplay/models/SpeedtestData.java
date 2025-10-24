package com.example.ISPStatDisplay.models;

import com.example.ISPStatDisplay.models.loadtest.DownloadTest;
import com.example.ISPStatDisplay.models.loadtest.UploadTest;
import com.example.ISPStatDisplay.models.ping.IdlePing;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class SpeedtestData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timestamp;

    @OneToOne
    @JoinColumn
    private IdlePing idlePing;

    @OneToOne
    @JoinColumn
    private DownloadTest downloadTest;

    @OneToOne
    @JoinColumn
    private UploadTest uploadTest;

    private Float packetLoss;

    private String isp;

    @ManyToOne
    @JoinColumn(name = "server_id", referencedColumnName = "server_id")
    private Server server;

    public SpeedtestData() {}

    public SpeedtestData(Long id, Timestamp timestamp, IdlePing idlePing, DownloadTest downloadTest, UploadTest uploadTest, Float packetLoss, String isp, Server server) {
        this.id = id;
        this.timestamp = timestamp;
        this.idlePing = idlePing;
        this.downloadTest = downloadTest;
        this.uploadTest = uploadTest;
        this.packetLoss = packetLoss;
        this.isp = isp;
        this.server = server;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public IdlePing getIdlePing() {
        return idlePing;
    }

    public void setIdlePing(IdlePing idlePing) {
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
