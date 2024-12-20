package com.receipt.generator.entities;

import com.receipt.generator.enums.SubscriptionStatus;
import com.receipt.generator.enums.SubscriptionType;

import java.util.Date;

public class Subscription {
    private String _id;
    private String user;
    private SubscriptionType subscriptionType;
    private Date startDate;
    private Date endDate;
    private SubscriptionStatus subscriptionStatus;

    public Subscription() {
    }

    public Subscription(String _id, String user, SubscriptionType subscriptionType, Date startDate, Date endDate, SubscriptionStatus subscriptionStatus) {
        this._id = _id;
        this.user = user;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.subscriptionStatus = subscriptionStatus;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}