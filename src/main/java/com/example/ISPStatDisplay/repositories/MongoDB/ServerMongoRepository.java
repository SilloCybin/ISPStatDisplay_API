package com.example.ISPStatDisplay.repositories.MongoDB;

import com.example.ISPStatDisplay.models.entities.MongoDB.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerMongoRepository extends MongoRepository<Server, Long>  {
}
