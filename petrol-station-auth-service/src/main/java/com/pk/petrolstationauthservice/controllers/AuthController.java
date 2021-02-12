package com.pk.petrolstationauthservice.controllers;

import com.pk.petrolstationauthservice.auth.JwtConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keys")
public class AuthController {

    private final JwtConfig jwtConfig;

    public AuthController(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/publickey")
    private ResponseEntity<byte[]> getPublicKey() {
        return  ResponseEntity.ok(jwtConfig.getPublicKey().getEncoded());
    }

}
