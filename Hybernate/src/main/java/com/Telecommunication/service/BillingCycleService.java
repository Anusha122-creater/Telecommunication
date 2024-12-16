package com.Telecommunication.service;

import java.util.List;

import com.Telecommunication.entity.BillingCycle;

public interface BillingCycleService {

    // Method to get all billing cycles
    List<BillingCycle> getAllBillingCycles();
    
    // Method to get a billing cycle by its ID
    BillingCycle getBillingCycleById(Integer billingCycleId);
    
    // Method to create a new billing cycle
    void createBillingCycle(BillingCycle billingCycle);
    
    // Method to update an existing billing cycle
    void updateBillingCycle(BillingCycle billingCycle);
    
    // Method to delete a billing cycle by its ID
    void deleteBillingCycle(Integer billingCycleId);
}
