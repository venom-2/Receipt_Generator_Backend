package com.receipt.generator.services;

import com.receipt.generator.configuration.SecurityConfig;
import com.receipt.generator.dao.UserDAO;
import com.receipt.generator.dto.LoginResponse;
import com.receipt.generator.dto.LoginRequest;
import com.receipt.generator.dto.UpdatePasswordRequest;
import com.receipt.generator.dto.UserRequest;
import com.receipt.generator.entities.Response;
import com.receipt.generator.entities.User;
import com.receipt.generator.translator.UserTranslator;
import com.receipt.generator.utilities.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    JwtUtility jwtUtility;

    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    UserTranslator userTranslator;

    public ResponseEntity<?> saveUser(UserRequest user) throws Exception {
        String hashedPassword = securityConfig.passwordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);

        User newUser = userTranslator.userRequestToUser(user);

        String msg = userDAO.saveUser(newUser);
        return ResponseEntity.ok(new Response(HttpStatus.ACCEPTED.value(), msg));
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) throws Exception{
        User user = userDAO.login(loginRequest);
        if(securityConfig.passwordEncoder().matches(loginRequest.getPassword(), user.getPassword())) {
            String authToken = jwtUtility.generateToken(loginRequest.getEmail());
            return ResponseEntity.ok()
                    .body(new LoginResponse(HttpStatus.ACCEPTED.value(), authToken, "Login successful"));

        } else {
            return ResponseEntity.badRequest()
                    .body(new LoginResponse(HttpStatus.FAILED_DEPENDENCY.value(), "", "Failed to login!"));
        }
    }

    public ResponseEntity<?> update(User user) throws Exception {
        Response response = userDAO.update(user);
        return ResponseEntity.ok(response);
    }

    public User getUser(String email) throws Exception {
        return userDAO.getUser(email);
    }

    public ResponseEntity<?> updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        Response response = userDAO.updatePassword(updatePasswordRequest);
        return ResponseEntity.ok(response);
    }
}



