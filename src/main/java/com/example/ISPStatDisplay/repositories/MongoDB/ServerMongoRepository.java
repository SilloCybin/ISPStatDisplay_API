package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.ServerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerMongoRepository extends MongoRepository<ServerMongo, Long>  {
}
