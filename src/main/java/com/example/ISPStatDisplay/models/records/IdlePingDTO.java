package com.example.ISPStatDisplay.models.records;

public record IdlePingDTO(Float jitter,
                          Float latency,
                          Float low,
                          Float high) {
}
