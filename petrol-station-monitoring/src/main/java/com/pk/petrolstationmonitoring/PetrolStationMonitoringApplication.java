package com.pk.petrolstationmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableEurekaClient
public class PetrolStationMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetrolStationMonitoringApplication.class, args);
    }


}
