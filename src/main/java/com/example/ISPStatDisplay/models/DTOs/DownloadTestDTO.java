package com.example.ISPStatDisplay.models.DTOs;

public record DownloadTestDTO(Long bandwidth,
                              Long bytes,
                              Float elapsed,
                              DownloadPingDTO downloadPing) {
}
