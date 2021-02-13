package com.pk.petrolstationgateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class PetrolStationGatewayApplication {

    private final static Logger logger = LoggerFactory.getLogger(PetrolStationGatewayApplication.class);

    public static void main(String[] args) {
        logger.trace("Gateway attempting to run");
        SpringApplication.run(PetrolStationGatewayApplication.class, args);
        logger.trace("Gateway running");
    }

}
