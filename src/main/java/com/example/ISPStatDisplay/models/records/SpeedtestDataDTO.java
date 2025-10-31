package com.example.ISPStatDisplay.models.records;

import java.sql.Timestamp;

public record SpeedtestDataDTO(Timestamp timestamp,
                               IdlePingDTO idlePing,
                               DownloadTestDTO downloadTest,
                               UploadTestDTO uploadTest,
                               Float packetLoss,
                               String isp,
                               ServerDTO server) {}
