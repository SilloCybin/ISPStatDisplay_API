package com.example.ISPStatDisplay.models.records;

public record UploadTestDTO(Long bandwidth,
                            Long bytes,
                            Float elapsed,
                            UploadPingDTO uploadPing) {}
