package com.receipt.generator.controllers;

import com.receipt.generator.dto.LoginRequest;
import com.receipt.generator.dto.UpdatePasswordRequest;
import com.receipt.generator.dto.UserRequest;
import com.receipt.generator.entities.User;
import com.receipt.generator.exceptions.ResourceNotFound;
import com.receipt.generator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*" )
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/fetch")
    public ResponseEntity<?> getUser() throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // This assumes 'username' is the email

        // Fetch user details using the email
        User user = userService.getUser(email);
        if (user == null) {
            throw new ResourceNotFound("User not found with email: " + email);
        }

        return ResponseEntity.ok(user);
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest){
        return userService.updatePassword(updatePasswordRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest user) throws Exception {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        return userService.login(loginRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }
}
