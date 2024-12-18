package com.receipt.generator.services;

import com.receipt.generator.dao.SubscriptionDAO;
import com.receipt.generator.dto.SubscriptionRequest;
import com.receipt.generator.entities.Response;
import com.receipt.generator.entities.Subscription;
import com.receipt.generator.translator.SubscriptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionDAO subscriptionDAO;

    @Autowired
    SubscriptionTranslator subscriptionTranslator;

    public Subscription getSubscription(String email) {
        Subscription subscription = subscriptionDAO.getSubscription(email);
        return subscription;
    }

    public ResponseEntity<?> startSubscription(SubscriptionRequest subscriptionRequest) {
        Subscription subscription = subscriptionTranslator.requestSubscriptionToSubscription(subscriptionRequest);
        Response response = subscriptionDAO.startSubscription(subscription);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    public ResponseEntity<?> updateSubscription(Subscription subscription) throws Exception {
        Response response = subscriptionDAO.updateSubscription(subscription);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
