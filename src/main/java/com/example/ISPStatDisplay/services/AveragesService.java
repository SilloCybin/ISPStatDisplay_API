package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.AveragesDTO;
import com.example.ISPStatDisplay.repositories.AveragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AveragesService {

    @Autowired
    private AveragesRepository repo;

    public AveragesDTO getAverages(){
        return repo.getAverages();
    }
}
