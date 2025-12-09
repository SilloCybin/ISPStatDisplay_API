package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.repositories.SpeedtestDataRepository;
import com.example.ISPStatDisplay.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeedtestDataService {

    @Autowired
    private SpeedtestDataRepository repo;

    public SpeedtestDataService(SpeedtestDataRepository speedtestDataRepository){
        this.repo = speedtestDataRepository;
    }

    public SpeedtestDataDTO getLatestSpeedTestData() {
        System.out.println("Ha");
        return this.repo.findTopByOrderByIdDesc().map(Utilities::speedtestBeanToDTOMapping).orElse(null);
    }

}
