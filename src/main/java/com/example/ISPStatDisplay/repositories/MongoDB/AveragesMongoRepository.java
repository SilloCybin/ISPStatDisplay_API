package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.Averages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AveragesMongoRepository extends MongoRepository<Averages, Long> {
}
