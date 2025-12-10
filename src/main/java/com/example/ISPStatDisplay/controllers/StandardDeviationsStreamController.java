package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.AveragesDTO;
import com.example.ISPStatDisplay.models.DTOs.StandardDeviationsDTO;
import com.example.ISPStatDisplay.services.StandardDeviationsStreamService;
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
public class StandardDeviationsStreamController {

    private final StandardDeviationsStreamService standardDeviationsStreamService;

    @GetMapping(value = "/standardDeviationsStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<StandardDeviationsDTO>> streamStandardDeviations() {
        return Flux.merge(
                this.standardDeviationsStreamService.stream()
                        .map(data -> ServerSentEvent.<StandardDeviationsDTO>builder()
                                .event("standard_deviations-update")
                                .data(data)
                                .build()
                        ),
                Flux.interval(Duration.ofMinutes(1))
                        .map(seq -> ServerSentEvent.<StandardDeviationsDTO>builder()
                                .event("keepalive")
                                .data(null)
                                .build())
        );

    }
}
