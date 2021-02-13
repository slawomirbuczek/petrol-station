package com.pk.petrolstationpricelist.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

@Service
public class ApiPublicKey {

    private final Logger logger = LoggerFactory.getLogger(ApiPublicKey.class);
    private final AuthProperties authProperties;

    private PublicKey publicKey;

    public ApiPublicKey(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }

    public PublicKey getPublicKey() {
        if (publicKey == null) {
            logger.trace("Public key is null, calling getPublicKeyFromAuthService method");
            this.publicKey = getPublicKeyFromAuthService();
        }
        return publicKey;
    }

    private PublicKey getPublicKeyFromAuthService() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            logger.trace("Trying to get public key from auth service");
            byte[] encodedPublicKey = restTemplate.getForObject(
                    "http://petrol-station-gateway:8762/auth/keys/publickey",
                    byte[].class
            );
            logger.trace("Got public key");

            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodedPublicKey));
        } catch (Exception e) {
            logger.error("Error occurred during getting public key from auth service", e);
            return null;
        }

    }

}
