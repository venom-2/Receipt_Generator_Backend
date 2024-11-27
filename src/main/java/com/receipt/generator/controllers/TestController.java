package com.receipt.generator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "https://receipt-generatorfrontend.vercel.app/" )
public class TestController {
    @GetMapping("/")
    public ResponseEntity<?> getMsg() {
        return ResponseEntity.ok("Welcome...");
    }
}
