package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.AveragesDTO;
import com.example.ISPStatDisplay.repositories.AveragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AveragesService {

    @Autowired
    private AveragesRepository repo;

    public AveragesService(AveragesRepository averagesRepository){
        this.repo = averagesRepository;
    }

    public AveragesDTO getAverages(){
        return this.repo.findById(1L).map(a -> new AveragesDTO(
                a.getDownloadBandwidth(),
                a.getUploadBandwidth(),
                a.getDownloadPingLatency(),
                a.getUploadPingLatency(),
                a.getIdlePingLatency(),
                a.getDownloadPingHigh(),
                a.getUploadPingHigh(),
                a.getIdlePingHigh(),
                a.getDownloadPingLow(),
                a.getUploadPingLow(),
                a.getIdlePingLow(),
                a.getDownloadPingJitter(),
                a.getUploadPingJitter(),
                a.getIdlePingJitter(),
                a.getPacketLoss()
        )).orElse(null);
    }
}
