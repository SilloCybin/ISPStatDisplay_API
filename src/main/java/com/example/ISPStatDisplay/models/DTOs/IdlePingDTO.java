package com.example.ISPStatDisplay.models.DTOs;

public record IdlePingDTO(Float jitter,
                          Float latency,
                          Float low,
                          Float high) {
}
