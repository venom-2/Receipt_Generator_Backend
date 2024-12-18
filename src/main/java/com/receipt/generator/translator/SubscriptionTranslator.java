package com.receipt.generator.translator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receipt.generator.dto.SubscriptionRequest;
import com.receipt.generator.entities.Subscription;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionTranslator {

    private static final ObjectMapper mapper = new ObjectMapper();
    public Subscription requestSubscriptionToSubscription(SubscriptionRequest subscriptionRequest) {
        return mapper.convertValue(subscriptionRequest, Subscription.class);
    }
}
