package com.example.ISPStatDisplay.repositories;

import com.example.ISPStatDisplay.models.Averages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AveragesRepository extends JpaRepository<Averages, Integer> {

     default Averages getSingleton(){
         return findById(1).orElse(null);
     }
}
