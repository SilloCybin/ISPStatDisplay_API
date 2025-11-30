package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.StandardDeviationsDTO;
import com.example.ISPStatDisplay.models.beans.documents.StandardDeviations;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;

@Service
public class StandardDeviationsStreamService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final Sinks.Many<StandardDeviationsDTO> sink;

    public StandardDeviationsStreamService(ReactiveMongoTemplate reactiveMongoTemplate){
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(StandardDeviationsDTO record) {
        sink.tryEmitNext(record);
    }

    public Flux<StandardDeviationsDTO> stream() {
        return this.sink.asFlux();
    }

    @PostConstruct
    public void initStream() {

        Document match = new Document("$match", new Document("operationType", new Document("$in", List.of("update", "replace"))));

        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .filter(match)
                .build();

        this.reactiveMongoTemplate.changeStream("standard_deviations", options, StandardDeviations.class)
                .map(ChangeStreamEvent::getBody)
                .map(standardDeviations -> new StandardDeviationsDTO(
                        standardDeviations.getDownloadBandwidth(),
                        standardDeviations.getUploadBandwidth(),
                        standardDeviations.getDownloadPingLatency(),
                        standardDeviations.getUploadPingLatency(),
                        standardDeviations.getIdlePingLatency(),
                        standardDeviations.getDownloadPingHigh(),
                        standardDeviations.getUploadPingHigh(),
                        standardDeviations.getIdlePingHigh(),
                        standardDeviations.getDownloadPingLow(),
                        standardDeviations.getUploadPingLow(),
                        standardDeviations.getIdlePingLow(),
                        standardDeviations.getDownloadPingJitter(),
                        standardDeviations.getUploadPingJitter(),
                        standardDeviations.getIdlePingJitter(),
                        standardDeviations.getPacketLoss()))
                .doOnNext(data -> {
                    System.out.println("StandardDeviations stream : New change detected in DB, publishing: " + data);
                })
                .doOnNext(this::publish)
                .subscribe();
    }
}
