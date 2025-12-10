package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.documents.Averages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AveragesRepository extends MongoRepository<Averages, Long> {}
