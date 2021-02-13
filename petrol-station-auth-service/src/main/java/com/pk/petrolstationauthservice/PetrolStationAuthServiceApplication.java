package com.pk.petrolstationauthservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetrolStationAuthServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(PetrolStationAuthServiceApplication.class);

    public static void main(String[] args) {
        logger.trace("AuthService attempting to run");
        SpringApplication.run(PetrolStationAuthServiceApplication.class, args);
        logger.trace("AuthService running");
    }



}
