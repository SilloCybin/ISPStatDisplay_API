package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.repositories.SpeedtestDataRepository;
import com.example.ISPStatDisplay.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpeedtestDataService {

    private final SpeedtestDataRepository repo;

    public SpeedtestDataDTO getLatestSpeedTestData() {
        return this.repo.findTopByOrderByIdDesc().map(Utilities::speedtestEntityToDTOMapping).orElse(null);
    }

}
