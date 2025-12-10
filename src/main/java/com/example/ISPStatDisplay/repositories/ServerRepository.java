package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.documents.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, Long>  {}