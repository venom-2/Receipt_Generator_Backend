package com.receipt.generator.controllers;

import com.receipt.generator.dto.SubscriptionRequest;
import com.receipt.generator.entities.Subscription;
import com.receipt.generator.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/")
    public ResponseEntity<?> getSubscription() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Subscription subscription = subscriptionService.getSubscription(email);
        return ResponseEntity.ok(subscription);
    }

    @PostMapping("/start")
    public ResponseEntity<?> startSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
        return subscriptionService.startSubscription(subscriptionRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSubscription(@RequestBody Subscription subscription) throws Exception {
        return subscriptionService.updateSubscription(subscription);
    }

}
