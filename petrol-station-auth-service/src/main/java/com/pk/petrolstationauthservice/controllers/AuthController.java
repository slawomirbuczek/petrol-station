package com.pk.petrolstationauthservice.controllers;

import com.pk.petrolstationauthservice.auth.JwtConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keys")
public class AuthController {

    private final JwtConfig jwtConfig;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/publickey")
    private ResponseEntity<byte[]> getPublicKey() {
        logger.trace("Get public key method called");
        return  ResponseEntity.ok(jwtConfig.getPublicKey().getEncoded());
    }

}
