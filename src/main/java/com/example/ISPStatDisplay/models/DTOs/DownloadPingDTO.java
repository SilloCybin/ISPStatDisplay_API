package com.example.ISPStatDisplay.models.DTOs;

public record DownloadPingDTO(Float jitter,
                              Float latency,
                              Float low,
                              Float high) {
}
