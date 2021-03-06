package com.pk.petrolstationauthservice.service;

import com.pk.petrolstationauthservice.entities.User;
import com.pk.petrolstationauthservice.model.Roles;
import com.pk.petrolstationauthservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestUsers {

    private final Logger logger = LoggerFactory.getLogger(TestUsers.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public TestUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    private void addTestUsers() {
        logger.trace("Adding test users");
        userRepository.save(new User(1L, "jan", passwordEncoder.encode("kowalski"), Roles.ADMIN));

        userRepository.save(new User(2L, "tomasz", passwordEncoder.encode("nowak"), Roles.CASHIER));
        userRepository.save(new User(3L, "karol", passwordEncoder.encode("kowalczyk"), Roles.CASHIER));

        userRepository.save(new User(4L, "wincenty", passwordEncoder.encode("raczek"), Roles.MONITORING));
        userRepository.save(new User(5L, "eugeniusz", passwordEncoder.encode("zuczek"), Roles.MONITORING));

        userRepository.save(new User(6L, "alojzy", passwordEncoder.encode("mydlak"), Roles.CAR_WASH));
        userRepository.save(new User(7L, "baltazar", passwordEncoder.encode("gabka"), Roles.CAR_WASH));

        userRepository.save(new User(8L, "czeslaw", passwordEncoder.encode("ratajczak"), Roles.LPG_SERVICE));
        userRepository.save(new User(9L, "radoslaw", passwordEncoder.encode("rataj"), Roles.LPG_SERVICE));

        userRepository.save(new User(10L, "Anon", passwordEncoder.encode("password"), Roles.USER));
    }

}
