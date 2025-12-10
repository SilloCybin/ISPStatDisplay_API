package com.example.ISPStatDisplay.models.beans.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "standard_deviations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardDeviations {

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
}


