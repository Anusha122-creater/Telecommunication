package com.Telecommunication.service;

import com.Telecommunication.entity.Subscriber;

import java.util.List;

public interface SubscriberService {

    // Method to get all subscribers
    List<Subscriber> getAllSubscribers();
    
    // Method to get a subscriber by ID
    Subscriber getSubscriberById(Integer subscriberId);
    
    // Method to create a new subscriber
    void createSubscriber(Subscriber subscriber);
    
    // Method to update an existing subscriber
    void updateSubscriber(Subscriber subscriber);
    
    // Method to delete a subscriber by ID
    void deleteSubscriber(Integer subscriberId);
}
