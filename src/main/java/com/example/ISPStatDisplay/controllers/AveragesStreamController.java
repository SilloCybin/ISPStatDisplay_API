package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.AveragesDTO;
import com.example.ISPStatDisplay.services.AveragesStreamService;
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
public class AveragesStreamController {

    private final AveragesStreamService averagesStreamService;

    @GetMapping(value = "/averagesStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<AveragesDTO>> streamAverages() {
        return Flux.merge(
                this.averagesStreamService.stream()
                        .map(data -> ServerSentEvent.<AveragesDTO>builder()
                                .event("averages-update")
                                .data(data)
                                .build()
                        ),
                Flux.interval(Duration.ofMinutes(1))
                        .map(seq -> ServerSentEvent.<AveragesDTO>builder()
                                .event("keepalive")
                                .data(null)
                                .build())
        );
    }
}
