package com.receipt.generator.controllers;

import com.receipt.generator.entities.Response;
import com.receipt.generator.services.OtpService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/signup")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate-otp")
    public ResponseEntity<?> generateOtp(@RequestParam String email) throws MessagingException {
        String otp = otpService.generateOtp(email);
        otpService.sendOtpEmail(email, otp);
        return ResponseEntity.ok(new Response(HttpStatus.ACCEPTED.value(), "OTP sent successfully to: " + email));
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<?> validateOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = otpService.validateOtp(email, otp);
        if (isValid) {
            return ResponseEntity.ok(new Response(HttpStatus.ACCEPTED.value(), "OTP verification successfully for: " + email));
        } else {
            return ResponseEntity.ok(new Response(HttpStatus.REQUEST_TIMEOUT.value(), "Invalid OTP or expired. Please request a new one."));
        }
    }
}
