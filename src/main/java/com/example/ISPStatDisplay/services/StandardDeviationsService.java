package com.example.ISPStatDisplay.services;

import com.example.ISPStatDisplay.models.records.StandardDeviationsDTO;
import com.example.ISPStatDisplay.repositories.JPA.StandardDeviationsJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StandardDeviationsService {

    @Autowired
    private StandardDeviationsJPARepository repo;

    public StandardDeviationsDTO getStandardDeviations(){
        return repo.getStandardDeviations();
    }
}
