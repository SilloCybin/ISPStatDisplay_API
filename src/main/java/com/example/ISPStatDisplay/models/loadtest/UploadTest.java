package com.example.ISPStatDisplay.models.loadtest;

import com.example.ISPStatDisplay.models.ping.UploadPing;

import javax.persistence.*;

@Entity
public class UploadTest extends LoadTest{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn
    UploadPing uploadPing;

    public UploadTest() {}

    public UploadTest(Long bandwidth, Long bytes, Float elapsed, Long id, UploadPing uploadPing) {
        super(bandwidth, bytes, elapsed);
        this.id = id;
        this.uploadPing = uploadPing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UploadPing getUploadPing() {
        return uploadPing;
    }

    public void setUploadPing(UploadPing uploadPing) {
        this.uploadPing = uploadPing;
    }
}