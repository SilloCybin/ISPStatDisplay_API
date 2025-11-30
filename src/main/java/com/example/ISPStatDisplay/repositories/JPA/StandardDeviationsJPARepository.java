package com.example.ISPStatDisplay.repositories.JPA;

import com.example.ISPStatDisplay.models.entities.JPA.StandardDeviations;
import com.example.ISPStatDisplay.models.records.AveragesDTO;
import com.example.ISPStatDisplay.models.records.StandardDeviationsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StandardDeviationsJPARepository extends JpaRepository<StandardDeviations, Integer> {

    @Query(""" 
     SELECT new com.example.ISPStatDisplay.models.records.StandardDeviationsDTO(
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
     FROM StandardDeviations a
     WHERE a.id = 1
     """)
    StandardDeviationsDTO getStandardDeviations();
}
