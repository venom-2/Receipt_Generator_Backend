package com.receipt.generator.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.*;

@Service
public class OtpService {

    private final ConcurrentHashMap<String, String> otpStore = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    private JavaMailSender mailSender;

    public String generateOtp(String email) {
        String cleanedEmail = email.trim().toLowerCase();

        Random random = new Random();
        String otp = String.format("%06d", random.nextInt(1000000));

        // Store OTP in-memory with cleaned email
        otpStore.put(cleanedEmail, otp);
        System.out.println("Generated OTP: " + otp + " for email: " + cleanedEmail);

        // Schedule the OTP to expire after 5 minutes
        scheduler.schedule(() -> {
            otpStore.remove(cleanedEmail);
            System.out.println("OTP expired for email: " + cleanedEmail);
        }, 5, TimeUnit.MINUTES);

        return otp;
    }

    // Send OTP via email
    public void sendOtpEmail(String email, String otp) throws MessagingException {
        String subject = "Your OTP Code for Receipt Generator";

        // HTML email body with responsive, clean, and professional design
        String body = "<html>"
                + "<body style='font-family: Arial, sans-serif; color: #333; margin: 0; padding: 0; background-color: #f4f4f4;'>"
                + "<div style='display: flex; justify-content: center; align-items: center; min-height: 100vh;'>"
                + "<div style='max-width: 600px; width: 100%; background: #ffffff; padding: 30px; "
                + "border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); text-align: center;'>"

                // Header
                + "<h2 style='color: #2d87f0; margin-bottom: 20px;'>Your OTP Code</h2>"
                + "<p style='font-size: 16px; color: #555; margin-bottom: 10px;'>"
                + "Thank you for using <strong>Receipt Generator</strong>!</p>"
                + "<p style='font-size: 16px; color: #555;'>Please use the OTP below to verify your account:</p>"

                // OTP in large, centered text
                + "<div style='margin: 20px 0; font-size: 32px; font-weight: bold; color: #f44336;'>"
                + otp
                + "</div>"

                // Expiration Note
                + "<p style='font-size: 14px; color: #888;'>This OTP is valid for <strong>5 minutes</strong>.</p>"

                // Footer
                + "<p style='font-size: 12px; color: #aaa; margin-top: 20px;'>"
                + "If you did not request this OTP, please ignore this email.</p>"
                + "<p style='font-size: 12px; color: #aaa;'>"
                + "Best regards,<br><strong>XceeDesigns Team</strong></p>"

                + "</div>" // End of content container
                + "</div>" // End of center alignment
                + "</body>"
                + "</html>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(body, true);

        mailSender.send(message);

        System.out.println("Professional HTML OTP sent to email: " + email);
    }

    public boolean validateOtp(String email, String otp) {
        String cleanedEmail = email.trim().toLowerCase();
        System.out.println("Stored OTP for validation: " + otpStore.get(cleanedEmail));
        System.out.println("Input OTP: " + otp);

        String storedOtp = otpStore.get(cleanedEmail);
        return storedOtp != null && storedOtp.equals(otp);
    }
}
