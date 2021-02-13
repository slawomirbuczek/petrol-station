package com.pk.petrolstationauthservice.service;

import com.pk.petrolstationauthservice.entities.User;
import com.pk.petrolstationauthservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.trace("Searching for user " + username + " in db");
        Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(
                () -> {
                    logger.trace("Throwing UsernameNotFoundException for user " + username);
                    return new UsernameNotFoundException("Username: " + username + " not found");
                }
        );

    }


}
