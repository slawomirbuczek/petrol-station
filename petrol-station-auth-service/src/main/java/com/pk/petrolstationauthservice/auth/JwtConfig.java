package com.pk.petrolstationauthservice.auth;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

@Configuration
public class JwtConfig {

    private final Logger logger = LoggerFactory.getLogger(JwtConfig.class);

    private final int expiration;

    private final PrivateKey privateKey;

    private final PublicKey publicKey;

    public JwtConfig() {
        logger.trace("Creating new KeyPair");
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
        this.expiration = 24*60*60;
    }

    public int getExpiration() {
        return expiration;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
