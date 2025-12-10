package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.StandardDeviationsDTO;
import com.example.ISPStatDisplay.services.StandardDeviationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StandardDeviationsController {

    private final StandardDeviationsService service;

    @GetMapping("/getStandardDeviations")
    public StandardDeviationsDTO getStandardDeviations(){
        return this.service.getStandardDeviations();
    }
}
