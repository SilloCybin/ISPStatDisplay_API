package com.example.ISPStatDisplay.models.records;

import java.time.Instant;

public record MetricPointDTO(Instant timestamp, Number value) {}
