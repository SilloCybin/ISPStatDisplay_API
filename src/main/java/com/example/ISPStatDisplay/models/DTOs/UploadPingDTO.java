package com.example.ISPStatDisplay.models.DTOs;

public record UploadPingDTO(Float jitter,
                            Float latency,
                            Float low,
                            Float high) {
}
