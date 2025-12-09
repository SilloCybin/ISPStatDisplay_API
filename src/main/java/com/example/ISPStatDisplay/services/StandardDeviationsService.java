package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.StandardDeviationsDTO;
import com.example.ISPStatDisplay.repositories.StandardDeviationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardDeviationsService {

    @Autowired
    private StandardDeviationsRepository repo;

    public StandardDeviationsService (StandardDeviationsRepository standardDeviationsRepository){
        this.repo = standardDeviationsRepository;
    }

    public StandardDeviationsDTO getStandardDeviations(){
        System.out.println("Ho");
        return this.repo.findById(1L).map(a -> new StandardDeviationsDTO(
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
