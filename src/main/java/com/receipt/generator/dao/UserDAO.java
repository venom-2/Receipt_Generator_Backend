package com.receipt.generator.dao;

import com.receipt.generator.configuration.SecurityConfig;
import com.receipt.generator.dto.LoginRequest;
import com.receipt.generator.dto.UpdatePasswordRequest;
import com.receipt.generator.dto.UserRequest;
import com.receipt.generator.entities.Response;
import com.receipt.generator.entities.User;
import com.receipt.generator.exceptions.DuplicateResource;
import com.receipt.generator.exceptions.ResourceNotFound;
import com.receipt.generator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityConfig securityConfig;

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

    public User login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        return user;
    }

    public Response update(User updatedUser) throws Exception{
        User existingUser = userRepository.findById(updatedUser.get_id())
                .orElseThrow(() -> new ResourceNotFound("User not found!"));

        // Update only non-null fields
        if (updatedUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }
        if (updatedUser.getMobileNumber() != null) {
            existingUser.setMobileNumber(updatedUser.getMobileNumber());
        }
        if (updatedUser.getCompanyName() != null) {
            existingUser.setCompanyName(updatedUser.getCompanyName());
        }
        if (updatedUser.getCountry() != null) {
            existingUser.setCountry(updatedUser.getCountry());
        }
        if (updatedUser.getState() != null) {
            existingUser.setState(updatedUser.getState());
        }

        // Save the updated user to MongoDB
        userRepository.save(existingUser);

        // Return success response
        return new Response(HttpStatus.OK.value(), "User updated successfully!");
    }

    public User getUser(String email) throws Exception {

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new ResourceNotFound("User not found with email: "+ email);
        }

        user.setPassword("");

        return user;

    }

    public Response updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        User user = userRepository.findById(updatePasswordRequest.get_id())
                .orElseThrow(()-> new ResourceNotFound("User not found with email: " + updatePasswordRequest.getUser()));
        if(!securityConfig.passwordEncoder().matches(updatePasswordRequest.getCurrentPassword(), user.getPassword())){
            return new Response(HttpStatus.EXPECTATION_FAILED.value(), "Password not matched!");
        }
        user.setPassword(
                securityConfig.passwordEncoder().encode(updatePasswordRequest.getNewPassword())
        );

        userRepository.save(user);

        return new Response(HttpStatus.ACCEPTED.value(), "Password updated successfully!");
    }
}
