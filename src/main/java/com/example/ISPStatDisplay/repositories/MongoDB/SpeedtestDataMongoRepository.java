package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.interfaces.IdOnly;
import com.example.ISPStatDisplay.models.entities.MongoDB.SpeedtestData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpeedtestDataMongoRepository extends MongoRepository<SpeedtestData, Long> {

    IdOnly findTopByOrderByIdDesc();
}
