package com.Telecommunication.service;

import com.Telecommunication.entity.Payment;

import java.util.List;

public interface PaymentService {

    // Method to get all payments
    List<Payment> getAllPayments();
    
    // Method to get a payment by its ID
    Payment getPaymentById(Integer paymentId);
    
    // Method to create a new payment
    void createPayment(Payment payment);
    
    // Method to update an existing payment
    void updatePayment(Payment payment);
    
    // Method to delete a payment by its ID
    void deletePayment(Integer paymentId);
}
