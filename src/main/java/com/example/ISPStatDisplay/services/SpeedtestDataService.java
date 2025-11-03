package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.documents.SpeedtestData;
import com.example.ISPStatDisplay.models.records.*;
import com.example.ISPStatDisplay.repositories.SpeedtestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeedtestDataService {

    @Autowired
    private SpeedtestDataRepository repo;

    public SpeedtestDataService(SpeedtestDataRepository speedtestDataRepository){
        this.repo = speedtestDataRepository;
    }

    public SpeedtestDataDTO getLatestSpeedTestData() {

        return repo.findTopByOrderByIdDesc().map(s -> new SpeedtestDataDTO(
                s.getTimestamp(),
                new IdlePingDTO(
                        s.getIdlePing().getJitter(),
                        s.getIdlePing().getLatency(),
                        s.getIdlePing().getLow(),
                        s.getIdlePing().getHigh()),
                new DownloadTestDTO(
                        s.getDownloadTest().getBandwidth(),
                        s.getDownloadTest().getBytes(),
                        s.getDownloadTest().getElapsed(),
                        new DownloadPingDTO(
                                s.getDownloadTest().getDownloadPing().getJitter(),
                                s.getDownloadTest().getDownloadPing().getLatency(),
                                s.getDownloadTest().getDownloadPing().getLow(),
                                s.getDownloadTest().getDownloadPing().getHigh())),
                new UploadTestDTO(
                        s.getUploadTest().getBandwidth(),
                        s.getUploadTest().getBytes(),
                        s.getUploadTest().getElapsed(),
                        new UploadPingDTO(
                                s.getUploadTest().getUploadPing().getJitter(),
                                s.getUploadTest().getUploadPing().getLatency(),
                                s.getUploadTest().getUploadPing().getLow(),
                                s.getUploadTest().getUploadPing().getHigh())),
                s.getPacketLoss(),
                s.getIsp(),
                new ServerDTO(
                        s.getServer().getServer_id(),
                        s.getServer().getHostname(),
                        s.getServer().getPort(),
                        s.getServer().getProvider(),
                        s.getServer().getLocation(),
                        s.getServer().getCountry(),
                        s.getServer().getIp()
        ))).orElse(null);
    }

}
