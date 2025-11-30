package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.StandardDeviations;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StandardDeviationsMongoRepository extends MongoRepository<StandardDeviations, Long> {
}
