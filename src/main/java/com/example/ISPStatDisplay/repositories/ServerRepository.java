package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.entities.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
}
