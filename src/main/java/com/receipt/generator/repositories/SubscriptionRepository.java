package com.receipt.generator.repositories;

import com.receipt.generator.entities.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    Subscription getByUser(String email);

    Subscription findByUser(String user);
}
