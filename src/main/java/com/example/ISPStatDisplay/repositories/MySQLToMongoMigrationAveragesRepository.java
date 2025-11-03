package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.Averages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MySQLToMongoMigrationAveragesRepository extends MongoRepository<Averages, Long> {
}
