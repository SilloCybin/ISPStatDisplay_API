package com.example.ISPStatDisplay.models.entities;

import com.example.ISPStatDisplay.models.mappedSuperclasses.LoadTest;

import jakarta.persistence.*;

@Entity
public class DownloadTest extends LoadTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn
    DownloadPing downloadPing;

    public DownloadTest() {}

    public DownloadTest(Long bandwidth, Long bytes, Float elapsed, Long id, DownloadPing downloadPing) {
        super(bandwidth, bytes, elapsed);
        this.id = id;
        this.downloadPing = downloadPing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DownloadPing getDownloadPing() {
        return downloadPing;
    }

    public void setDownloadPing(DownloadPing downloadPing) {
        this.downloadPing = downloadPing;
    }
}
