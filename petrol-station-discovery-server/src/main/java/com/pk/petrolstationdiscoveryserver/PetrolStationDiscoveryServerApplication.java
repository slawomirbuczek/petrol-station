package com.pk.petrolstationdiscoveryserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PetrolStationDiscoveryServerApplication {

    private final static Logger logger = LoggerFactory.getLogger(PetrolStationDiscoveryServerApplication.class);

    public static void main(String[] args) {
        logger.trace("Discovery server attempting to run");
        SpringApplication.run(PetrolStationDiscoveryServerApplication.class, args);
        logger.trace("Discovery server running");
    }



}
