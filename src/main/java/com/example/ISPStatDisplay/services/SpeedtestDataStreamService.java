package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.models.beans.documents.Server;
import com.example.ISPStatDisplay.models.beans.documents.SpeedtestData;
import com.example.ISPStatDisplay.utilities.Utilities;
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
        return this.sink.asFlux();
    }

    @PostConstruct
    public void initStream() {

        Document match = new Document("$match", new Document("operationType", "insert"));

        ChangeStreamOptions options = ChangeStreamOptions.builder()
                .filter(match)
                .build();

        this.reactiveMongoTemplate.changeStream("speedtest_data", options, SpeedtestData.class)
                .map(ChangeStreamEvent::getBody)
                .flatMap(this::enrichWithServer)
                .map(Utilities::speedtestBeanToDTOMapping)
                .doOnNext(data -> {
                    System.out.println("Speedtest_data stream : New change detected in DB, publishing: " + data);
                })
                .doOnNext(this::publish)
                .subscribe();
    }

    public Mono<SpeedtestData> enrichWithServer(SpeedtestData speedtestData){

        return this.reactiveMongoTemplate.findById(speedtestData.getServer().getServer_id(), Server.class)
                .map(server -> new SpeedtestData(
                        speedtestData.getId(),
                        speedtestData.getTimestamp(),
                        speedtestData.getIdlePing(),
                        speedtestData.getDownloadTest(),
                        speedtestData.getUploadTest(),
                        speedtestData.getPacketLoss(),
                        speedtestData.getIsp(),
                        server));
    }
}
