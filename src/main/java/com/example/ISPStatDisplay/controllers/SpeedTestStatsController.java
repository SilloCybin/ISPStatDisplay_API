package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.records.SpeedtestDataDTO;
import com.example.ISPStatDisplay.services.SpeedTestStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class SpeedTestStatsController {

    @Autowired
    private final SpeedTestStatsService service = new SpeedTestStatsService();

    @GetMapping("/getLatestSpeedtestData")
    public ResponseEntity<SpeedtestDataDTO> getLatestSpeedtestData() {
        try {
            SpeedtestDataDTO data = service.getLatestSpeedTestData();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}