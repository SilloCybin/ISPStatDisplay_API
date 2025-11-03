package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.ServerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MySQLToMongoMigrationServerRepository extends MongoRepository<ServerMongo, Long>  {
}
