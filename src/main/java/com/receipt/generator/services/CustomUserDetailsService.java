package com.receipt.generator.services;

import com.receipt.generator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user in the database by email (or username)
        com.receipt.generator.entities.User userEntity = userRepository.findByEmail(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Construct UserDetails object with plain-text password
        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }

}
