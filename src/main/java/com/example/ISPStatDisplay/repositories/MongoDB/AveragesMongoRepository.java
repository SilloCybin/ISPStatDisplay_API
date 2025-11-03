package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.AveragesMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AveragesMongoRepository extends MongoRepository<AveragesMongo, Long> {
}
