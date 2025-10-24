package com.example.ISPStatDisplay.models.ping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UploadPing extends Ping{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public UploadPing() {
        super();
    }

    public UploadPing(Long Id, Float jitter, Float latency, Float low, Float high) {
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
