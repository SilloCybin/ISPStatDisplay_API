package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.Averages;
import com.example.ISPStatDisplay.services.AveragesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AveragesController {

    @Autowired
    private final AveragesService service = new AveragesService();

    @GetMapping("/getAverages")
    public Averages getAverages(){
        return this.service.getAverages();
    }
}
