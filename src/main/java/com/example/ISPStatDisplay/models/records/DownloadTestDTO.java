package com.example.ISPStatDisplay.models.records;

public record DownloadTestDTO(Long bandwidth,
                              Long bytes,
                              Float elapsed,
                              DownloadPingDTO downloadPing) {
}
