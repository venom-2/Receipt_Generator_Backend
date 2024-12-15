package com.receipt.generator.dao;

import com.receipt.generator.dto.UserRequest;
import com.receipt.generator.entities.User;
import com.receipt.generator.exceptions.DuplicateResource;
import com.receipt.generator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    UserRepository userRepository;

    public String saveUser(User user) throws DuplicateResource {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null) {
            throw new DuplicateResource("User already exists with this email id!");
        }
        try{
            userRepository.save(user);
            return "User saved successfully!";
        } catch (Exception e) {
            return "Failed to add user!";
        }
    }

    public User login(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail());
        return user;
    }
}
