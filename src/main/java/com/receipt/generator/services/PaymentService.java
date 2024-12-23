package com.receipt.generator.services;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @Value("${razorpay.currency}")
    private String currency;

    public Order createOrder(double amount) {
        try {
            RazorpayClient client = new RazorpayClient(keyId, keySecret);

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100);
            orderRequest.put("currency", currency);
            orderRequest.put("receipt", "txn_123456");

            return client.orders.create(orderRequest);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create order", e);
        }
    }
}

