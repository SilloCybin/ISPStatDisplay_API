package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.services.SpeedtestDataStreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class SpeedtestDataStreamController {

    private final SpeedtestDataStreamService speedtestDataStreamService;

    @GetMapping(value = "/speedtestDataStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<SpeedtestDataDTO>> streamSpeedtestData() {
        return Flux.merge(
                this.speedtestDataStreamService.stream()
                        .map(data -> ServerSentEvent.<SpeedtestDataDTO>builder()
                                .event("speedtest_data-update")
                                .data(data)
                                .build()),
                Flux.interval(Duration.ofMinutes(1))
                        .map(seq -> ServerSentEvent.<SpeedtestDataDTO>builder()
                                .event("keepalive")
                                .data(null)
                                .build())
        );
    }
}
