package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.documents.StandardDeviations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StandardDeviationsRepository extends MongoRepository<StandardDeviations, Long> {}
