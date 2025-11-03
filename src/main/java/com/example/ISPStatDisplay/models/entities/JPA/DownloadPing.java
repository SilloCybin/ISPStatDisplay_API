package com.example.ISPStatDisplay.models.entities.JPA;

import com.example.ISPStatDisplay.models.entities.JPA.mappedSuperclasses.Ping;
import jakarta.persistence.*;

@Entity
public class DownloadPing extends Ping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public DownloadPing() {
        super();
    }

    public DownloadPing(Long Id, Float jitter, Float latency, Float low, Float high) {
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
