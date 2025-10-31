package com.example.ISPStatDisplay.models.records;

public record UploadPingDTO(Float jitter,
                            Float latency,
                            Float low,
                            Float high) {
}
