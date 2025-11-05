package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.records.AveragesDTO;
import com.example.ISPStatDisplay.services.AveragesStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AveragesStreamController {

    @Autowired
    private AveragesStreamService averagesStreamService;

    public AveragesStreamController(AveragesStreamService averagesStreamService){
        this.averagesStreamService = averagesStreamService;
    }

    @GetMapping(value = "/averagesStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<AveragesDTO>> streamAverages(){
        return this.averagesStreamService.stream()
                .map(data -> ServerSentEvent.<AveragesDTO>builder()
                        .event("averages-update")
                        .data(data)
                        .build()
                );
    }
}
