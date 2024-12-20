package com.receipt.generator.dao;

import com.receipt.generator.entities.Response;
import com.receipt.generator.entities.Subscription;
import com.receipt.generator.exceptions.ResourceNotFound;
import com.receipt.generator.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionDAO {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Subscription getSubscription(String email) {
        Subscription subscription = subscriptionRepository.getByUser(email);
        if(subscription == null) {
            throw new ResourceNotFound("Subscription not fount for user: "+ email);
        }
        return subscription;
    }

    public Response startSubscription(Subscription subscription) {
        try{
            Subscription sub = subscriptionRepository.findByUser(subscription.getUser());
            if(sub != null){
                return new Response(HttpStatus.NOT_ACCEPTABLE.value(), "Try to update your subscription status!");
            }
            subscriptionRepository.save(subscription);
            return new Response(HttpStatus.CREATED.value(), "Subscription started successfully!");
        } catch (Exception exception) {
            return new Response(HttpStatus.PRECONDITION_FAILED.value(), "Failed to start subscription!");
        }
    }

    public Response updateSubscription(Subscription subscription) throws Exception{
        Subscription sub = subscriptionRepository.findByUser(subscription.getUser());
        if(sub == null) {
            throw new ResourceNotFound("Subscription not found!");
        }
        try{
            subscriptionRepository.save(subscription);
            return new Response(HttpStatus.ACCEPTED.value(), "Subscription updated successfully!");
        } catch (Exception exception) {
            return new Response(HttpStatus.PRECONDITION_FAILED.value(), "Subscription update failed!");
        }
    }
}
