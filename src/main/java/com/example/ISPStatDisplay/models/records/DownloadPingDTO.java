package com.example.ISPStatDisplay.models.records;

public record DownloadPingDTO(Float jitter,
                              Float latency,
                              Float low,
                              Float high) {
}
