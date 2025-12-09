package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.services.SpeedtestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class SpeedtestDataController {

    @Autowired
    private final SpeedtestDataService service;

    public SpeedtestDataController(SpeedtestDataService speedtestDataService){
        this.service = speedtestDataService;
    }

    @GetMapping("/getLatestSpeedtestData")
    public ResponseEntity<SpeedtestDataDTO> getLatestSpeedtestData() {
        System.out.println("Hit getLatestSpeedtestData endpoint");
        try {
            SpeedtestDataDTO data = this.service.getLatestSpeedTestData();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}