package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.SpeedtestDataDTO;
import com.example.ISPStatDisplay.services.SpeedtestDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class SpeedtestDataController {

    private final SpeedtestDataService service;

    @GetMapping("/getLatestSpeedtestData")
    public ResponseEntity<SpeedtestDataDTO> getLatestSpeedtestData() {
        try {
            SpeedtestDataDTO data = this.service.getLatestSpeedTestData();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}