package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.Averages;
import com.example.ISPStatDisplay.models.records.AveragesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AveragesRepository extends JpaRepository<Averages, Integer> {

    @Query (""" 
     SELECT new com.example.ISPStatDisplay.models.records.AveragesDTO(
     a.downloadBandwidth,
     a.uploadBandwidth,
     a.downloadPingLatency,
     a.uploadPingLatency,
     a.idlePingLatency,
     a.downloadPingLow,
     a.uploadPingLow,
     a.idlePingLow,
     a.downloadPingHigh,
     a.uploadPingHigh,
     a.idlePingHigh,
     a.downloadPingJitter,
     a.uploadPingJitter,
     a.idlePingJitter,
     a.packetLoss)
     FROM Averages a
     WHERE a.id = 1
     """)
    AveragesDTO getAverages();
}
