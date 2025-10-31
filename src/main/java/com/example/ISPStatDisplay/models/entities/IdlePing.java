package com.example.ISPStatDisplay.models.entities;

import com.example.ISPStatDisplay.models.mappedSuperclasses.Ping;
import jakarta.persistence.*;

@Entity
public class IdlePing extends Ping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public IdlePing() {
        super();
    }

    public IdlePing(Long Id, Float jitter, Float latency, Float low, Float high) {
        super(jitter, latency, low, high);
        this.id = Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
