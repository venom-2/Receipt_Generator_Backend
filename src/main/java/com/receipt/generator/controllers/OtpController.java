package com.receipt.generator.controllers;

import com.receipt.generator.services.OtpService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/signup")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate-otp")
    public String generateOtp(@RequestParam String email) throws MessagingException {
        String otp = otpService.generateOtp(email);
        otpService.sendOtpEmail(email, otp);
        return "OTP sent successfully to: " + email;
    }

    @PostMapping("/validate-otp")
    public String validateOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = otpService.validateOtp(email, otp);
        if (isValid) {
            return "OTP is valid. You can now complete registration.";
        } else {
            return "Invalid OTP or expired. Please request a new one.";
        }
    }
}
