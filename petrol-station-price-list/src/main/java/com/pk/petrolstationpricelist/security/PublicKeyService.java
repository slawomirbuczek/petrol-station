package com.pk.petrolstationpricelist.security;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

@Service
public class PublicKeyService {

    public PublicKey getPublicKey() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            byte[] encodedPublicKey = restTemplate.getForObject(
                    "http://petrol-station-gateway:8762/auth/keys/publickey",
                    byte[].class
            );

            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(encodedPublicKey));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

}
