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
    public void sendOtpEmail(String email, String otp) throws MessagingException, MessagingException {
        String subject = "Your OTP Code";
        String body = "<html>"
                + "<body style='font-family: Arial, sans-serif; color: #333;'>"
                + "<h2 style='color: #2d87f0;'>Your OTP Code</h2>"
                + "<p>Dear User,</p>"
                + "<p>Thank you for registering with us! Your OTP code is:</p>"
                + "<h1 style='color: #f44336; font-size: 40px;'>" + otp + "</h1>"
                + "<p style='font-size: 16px;'>This code will expire in 5 minutes.</p>"
                + "<p>If you did not request this OTP, please ignore this message.</p>"
                + "<br>"
                + "<p>Best regards,</p>"
                + "<p><b>XceeDesigns</b></p>"
                + "</body>"
                + "</html>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(body, true);

        mailSender.send(message);

        System.out.println("HTML OTP sent to email: " + email);
    }

    public boolean validateOtp(String email, String otp) {
        String cleanedEmail = email.trim().toLowerCase();
        System.out.println("Stored OTP for validation: " + otpStore.get(cleanedEmail));
        System.out.println("Input OTP: " + otp);

        String storedOtp = otpStore.get(cleanedEmail);
        return storedOtp != null && storedOtp.equals(otp);
    }
}
