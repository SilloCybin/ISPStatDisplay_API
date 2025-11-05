package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.AveragesDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

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
        return sink.asFlux();
    }

    @PostConstruct
    public void initStream() {
        this.reactiveMongoTemplate.changeStream(AveragesDTO.class)
                .listen()
                .map(ChangeStreamEvent::getBody)
                .doOnNext(this::publish)
                .subscribe();
    }
}
