package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.records.SpeedtestDataDTO;
import com.example.ISPStatDisplay.services.SpeedtestDataStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SpeedtestDataStreamController {

    @Autowired
    private SpeedtestDataStreamService speedtestDataStreamService;

    public SpeedtestDataStreamController(SpeedtestDataStreamService speedtestDataStreamService){
        this.speedtestDataStreamService = speedtestDataStreamService;
    }

    @GetMapping(value = "/speedtestDataStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<SpeedtestDataDTO>> streamSpeedtestData(){
        return this.speedtestDataStreamService.stream()
                .map(data -> ServerSentEvent.<SpeedtestDataDTO>builder()
                        .event("speedtest_data-update")
                        .data(data)
                        .build()
                );
    }

}
