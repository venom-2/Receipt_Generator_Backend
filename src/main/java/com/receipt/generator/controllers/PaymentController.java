package com.receipt.generator.controllers;

import com.receipt.generator.dto.PaymentVerificationRequest;
import com.receipt.generator.entities.Response;
import com.receipt.generator.services.PaymentService;
import com.receipt.generator.utilities.PaymentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentUtility paymentUtility;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestParam double amount) {
        return ResponseEntity.ok(paymentService.createOrder(amount));
    }

    @PostMapping("/verifyPayment")
    public ResponseEntity<?> verifyPayment(@RequestBody PaymentVerificationRequest paymentVerificationRequest) {
        try {
            String generatedSignature = paymentUtility.HmacSHA256(paymentVerificationRequest.getOrderId() + "|" + paymentVerificationRequest.getPaymentId(), keySecret);
            if (generatedSignature.equals(paymentVerificationRequest.getSignature())) {
                return ResponseEntity.ok(new Response(HttpStatus.ACCEPTED.value(), "Payment verification successful!"));
            } else {
                return ResponseEntity.ok(new Response(HttpStatus.BAD_REQUEST.value(), "Payment verification failed!"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error - try again later!"));
        }
    }

}

