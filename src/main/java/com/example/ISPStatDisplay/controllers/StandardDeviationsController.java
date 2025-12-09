package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.StandardDeviationsDTO;
import com.example.ISPStatDisplay.services.StandardDeviationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardDeviationsController {

    @Autowired
    private final StandardDeviationsService service;

    public StandardDeviationsController(StandardDeviationsService standardDeviationsService){
        this.service = standardDeviationsService;
    }

    @GetMapping("/getStandardDeviations")
    public StandardDeviationsDTO getStandardDeviations(){
        System.out.println("Hit getStandardDeviations endpoint");
        return this.service.getStandardDeviations();
    }
}
