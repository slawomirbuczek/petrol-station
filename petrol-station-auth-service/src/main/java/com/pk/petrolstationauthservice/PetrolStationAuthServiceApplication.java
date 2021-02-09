package com.pk.petrolstationauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetrolStationAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetrolStationAuthServiceApplication.class, args);
    }



}
