package com.example.ISPStatDisplay.repositories.JPA;

import com.example.ISPStatDisplay.models.entities.JPA.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerJPARepository extends JpaRepository<Server, Long> {
}
