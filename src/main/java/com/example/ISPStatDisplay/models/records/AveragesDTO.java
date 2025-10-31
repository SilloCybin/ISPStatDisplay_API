package com.example.ISPStatDisplay.models.records;

public record AveragesDTO(Long downloadBandwidth,
                          Long uploadBandwidth,
                          Float downloadPingLatency,
                          Float uploadPingLatency,
                          Float idlePingLatency,
                          Float downloadPingHigh,
                          Float uploadPingHigh,
                          Float idlePingHigh,
                          Float downloadPingLow,
                          Float uploadPingLow,
                          Float idlePingLow,
                          Float downloadPingJitter,
                          Float uploadPingJitter,
                          Float idlePingJitter,
                          Float packetLoss) {}
