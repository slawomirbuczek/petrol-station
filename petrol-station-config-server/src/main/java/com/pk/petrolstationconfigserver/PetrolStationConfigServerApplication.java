package com.pk.petrolstationconfigserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class PetrolStationConfigServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(PetrolStationConfigServerApplication.class);

    public static void main(String[] args) {
        logger.trace("Config server attempting to run");
        SpringApplication.run(PetrolStationConfigServerApplication.class, args);
        logger.trace("Config server running");

    }

}
