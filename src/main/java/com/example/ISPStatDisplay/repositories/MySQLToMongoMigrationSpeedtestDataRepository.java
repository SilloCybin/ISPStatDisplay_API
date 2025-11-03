package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.SpeedtestData;
import com.example.ISPStatDisplay.models.entities.SpeedtestDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MySQLToMongoMigrationSpeedtestDataRepository extends MongoRepository<SpeedtestDataMongo, Long> {
}
