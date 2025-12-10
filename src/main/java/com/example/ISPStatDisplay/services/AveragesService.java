package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.AveragesDTO;
import com.example.ISPStatDisplay.repositories.AveragesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AveragesService {

    private final AveragesRepository repo;

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
