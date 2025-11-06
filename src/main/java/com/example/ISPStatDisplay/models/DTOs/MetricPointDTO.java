package com.example.ISPStatDisplay.models.DTOs;

import java.time.Instant;

public record MetricPointDTO(Instant timestamp, Number value) {}
