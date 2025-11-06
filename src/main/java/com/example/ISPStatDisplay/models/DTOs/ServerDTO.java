package com.example.ISPStatDisplay.models.DTOs;

public record ServerDTO(Long server_id,
                        String hostname,
                        Long port,
                        String provider,
                        String location,
                        String country,
                        String ip) {
}
