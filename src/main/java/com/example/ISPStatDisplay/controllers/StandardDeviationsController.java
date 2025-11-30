package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.records.StandardDeviationsDTO;
import com.example.ISPStatDisplay.services.StandardDeviationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardDeviationsController {

    @Autowired
    private final StandardDeviationsService service = new StandardDeviationsService();

    @GetMapping("/getStandardDeviations")
    public StandardDeviationsDTO getStandardDeviations(){
        return this.service.getStandardDeviations();
    }
}
