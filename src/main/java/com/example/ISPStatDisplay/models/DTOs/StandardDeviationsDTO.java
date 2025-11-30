package com.example.ISPStatDisplay.models.DTOs;

public record StandardDeviationsDTO(Long downloadBandwidth,
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