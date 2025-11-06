package com.example.ISPStatDisplay.models.DTOs;

public record UploadTestDTO(Long bandwidth,
                            Long bytes,
                            Float elapsed,
                            UploadPingDTO uploadPing) {}
