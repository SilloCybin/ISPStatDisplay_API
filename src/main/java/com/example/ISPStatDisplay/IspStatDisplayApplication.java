package com.example.ISPStatDisplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IspStatDisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IspStatDisplayApplication.class, args);
	}

}
