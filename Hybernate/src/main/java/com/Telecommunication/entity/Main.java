package com.Telecommunication.entity;

import com.Telecommunication.entity.BillingCycle;
import com.Telecommunication.entity.Call;
import com.Telecommunication.entity.Inventory;
import com.Telecommunication.entity.Message;
import com.Telecommunication.entity.NetworkElement;
import com.Telecommunication.entity.Payment;
import com.Telecommunication.entity.Subscriber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("telecommunication");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create a subscriber
        Subscriber subscriber = new Subscriber();
        subscriber.setName("Akhila");
        subscriber.setPhoneNumber(986754399L);
        subscriber.setAddress("Hyderabad");

        entityManager.getTransaction().begin();
        entityManager.persist(subscriber);
        entityManager.getTransaction().commit();

        // Create a billing cycle
        BillingCycle billingCycle = new BillingCycle();
        billingCycle.setSubscriber(subscriber);
        billingCycle.setBillingDate(new java.util.Date());
        billingCycle.setAmount(100.0);

        entityManager.getTransaction().begin();
        entityManager.persist(billingCycle);
        entityManager.getTransaction().commit();

        // Create a call
        Call call = new Call();
        call.setSubscriber(subscriber);
        call.setCallDate(new java.util.Date());
        call.setCallTime("10:00 AM");
        call.setCalledParty("Akhila");
        call.setCallDuration(30);

        entityManager.getTransaction().begin();
        entityManager.persist(call);
        entityManager.getTransaction().commit();

        // Create a message
        Message message = new Message();
        message.setSubscriber(subscriber);
        message.setMessageDate(new java.util.Date());
        message.setMessageTime("10:00 AM");
        message.setMessageType("Text");
        message.setMessageContent("Hello, world!");

        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();

        // Create an inventory item
        Inventory inventory = new Inventory();
        inventory.setEquipmentType("Router");
        inventory.setQuantity(10);

        entityManager.getTransaction().begin();
        entityManager.persist(inventory);
        entityManager.getTransaction().commit();

        // Create a network element
        NetworkElement networkElement = new NetworkElement();
        networkElement.setType("Router");
        networkElement.setLocation("Telangana");

        entityManager.getTransaction().begin();
        entityManager.persist(networkElement);
        entityManager.getTransaction().commit();

        // Create a payment
        Payment payment = new Payment();
        payment.setBillingCycle(billingCycle);
        payment.setPaymentDate(new java.util.Date());
        payment.setPaymentMethod("Credit Card");

        entityManager.getTransaction().begin();
        entityManager.persist(payment);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}


