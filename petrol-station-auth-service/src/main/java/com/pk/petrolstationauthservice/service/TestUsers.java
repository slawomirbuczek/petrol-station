package com.pk.petrolstationauthservice.service;

import com.pk.petrolstationauthservice.entities.User;
import com.pk.petrolstationauthservice.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUsers {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TestUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void addTestUsers() {
        userRepository.save(new User("Anon", passwordEncoder.encode("password")));
    }


}
