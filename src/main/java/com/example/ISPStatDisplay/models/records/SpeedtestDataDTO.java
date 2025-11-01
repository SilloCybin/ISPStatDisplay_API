package com.example.ISPStatDisplay.models.records;

import java.time.Instant;

public record SpeedtestDataDTO(Instant timestamp,
                               IdlePingDTO idlePing,
                               DownloadTestDTO downloadTest,
                               UploadTestDTO uploadTest,
                               Float packetLoss,
                               String isp,
                               ServerDTO server) {}
