package com.example.sdakiliszekwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.sdakiliszekwebapi.model")
@EnableJpaRepositories(basePackages = "com.example.sdakiliszekwebapi.repository")

public class ExceptionHandlingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionHandlingApplication.class, args);
    }
}

