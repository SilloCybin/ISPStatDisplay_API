package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.SpeedtestDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpeedtestDataMongoRepository extends MongoRepository<SpeedtestDataMongo, Long> {
}
