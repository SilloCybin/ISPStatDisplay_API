package com.example.ISPStatDisplay.controllers;

import com.example.ISPStatDisplay.models.DTOs.AveragesDTO;
import com.example.ISPStatDisplay.services.AveragesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AveragesController {

    private final AveragesService service;

    @GetMapping("/getAverages")
    public AveragesDTO getAverages(){
        return this.service.getAverages();
    }
}
