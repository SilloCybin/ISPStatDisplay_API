package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.ServerDTO;
import com.example.ISPStatDisplay.models.records.SpeedtestDataDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.bson.Document;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class SpeedtestDataStreamService {

    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final Sinks.Many<SpeedtestDataDTO> sink;

    public SpeedtestDataStreamService(ReactiveMongoTemplate reactiveMongoTemplate){
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(SpeedtestDataDTO record) {
        sink.tryEmitNext(record);
    }

    public Flux<SpeedtestDataDTO> stream() {
        return sink.asFlux();
    }

    @PostConstruct
    public void initStream() {

        Document match = new Document("$match", new Document("operationType", "insert"));

        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .filter(match)
                .build();

        this.reactiveMongoTemplate.changeStream("speedtestData", options, SpeedtestDataDTO.class)
                .map(ChangeStreamEvent::getBody)
                .flatMap(this::enrichWithServer)
                .doOnNext(this::publish)
                .subscribe();
    }

    public Mono<SpeedtestDataDTO> enrichWithServer(SpeedtestDataDTO speedtestDataDTO){
        if (speedtestDataDTO.server() == null){
            return Mono.just(speedtestDataDTO);
        }

        return reactiveMongoTemplate.findById(speedtestDataDTO.server().server_id(), ServerDTO.class)
                .map(serverDTO -> new SpeedtestDataDTO(
                        speedtestDataDTO.timestamp(),
                        speedtestDataDTO.idlePing(),
                        speedtestDataDTO.downloadTest(),
                        speedtestDataDTO.uploadTest(),
                        speedtestDataDTO.packetLoss(),
                        speedtestDataDTO.isp(),
                        serverDTO
                ));
    }
}
