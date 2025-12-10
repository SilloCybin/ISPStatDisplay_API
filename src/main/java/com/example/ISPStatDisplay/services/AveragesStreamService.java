package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.beans.documents.Averages;
import com.example.ISPStatDisplay.models.DTOs.AveragesDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.List;

@Service
public class AveragesStreamService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final Sinks.Many<AveragesDTO> sink;

    public AveragesStreamService(ReactiveMongoTemplate reactiveMongoTemplate){
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(AveragesDTO record) {
        sink.tryEmitNext(record);
    }

    public Flux<AveragesDTO> stream() {
        return this.sink.asFlux();
    }

    @PostConstruct
    public void initStream() {

        Document match = new Document("$match", new Document("operationType", new Document("$in", List.of("update", "replace"))));

        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .filter(match)
                .build();

        this.reactiveMongoTemplate.changeStream("averages", options, Averages.class)
                .map(ChangeStreamEvent::getBody)
                .map(averages -> new AveragesDTO(
                        averages.getDownloadBandwidth(),
                        averages.getUploadBandwidth(),
                        averages.getDownloadPingLatency(),
                        averages.getUploadPingLatency(),
                        averages.getIdlePingLatency(),
                        averages.getDownloadPingHigh(),
                        averages.getUploadPingHigh(),
                        averages.getIdlePingHigh(),
                        averages.getDownloadPingLow(),
                        averages.getUploadPingLow(),
                        averages.getIdlePingLow(),
                        averages.getDownloadPingJitter(),
                        averages.getUploadPingJitter(),
                        averages.getIdlePingJitter(),
                        averages.getPacketLoss()))
                .doOnNext(data -> {
                    System.out.println("Averages stream : New change detected in DB, publishing: " + data);
                })
                .doOnNext(this::publish)
                .subscribe();
    }
}
