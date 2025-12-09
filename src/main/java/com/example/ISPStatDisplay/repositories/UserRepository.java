package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.beans.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}