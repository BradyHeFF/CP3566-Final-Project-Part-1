package com.example.educationsystem;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.educationsystem.entity"})
public class EducationSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(EducationSystemApplication.class, args);
	}
}

