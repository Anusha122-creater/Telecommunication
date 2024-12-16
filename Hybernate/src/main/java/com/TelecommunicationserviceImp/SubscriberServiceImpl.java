package com.TelecommunicationserviceImp;


import com.Telecommunication.entity.Subscriber;
import com.Telecommunication.service.SubscriberService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public abstract class SubscriberServiceImpl implements SubscriberService {

  
    private SessionFactory sessionFactory;

    // Get all subscribers
    @Override
    public List<Subscriber> getAllSubscribers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Subscriber", Subscriber.class).list();
        }
    }

    // Get subscriber by ID
    @Override
    public Subscriber getSubscriberById(Integer subscriberId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Subscriber.class, subscriberId);
        }
    }

    // Create a new subscriber
    @Override
    public void createSubscriber(Subscriber subscriber) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(subscriber); // Save new subscriber
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update an existing subscriber
    @Override
    public void updateSubscriber(Subscriber subscriber) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(subscriber); // Update subscriber
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete a subscriber
    @Override
    public void deleteSubscriber(Integer subscriberId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Subscriber subscriber = session.get(Subscriber.class, subscriberId);
            if (subscriber != null) {
                session.delete(subscriber); // Delete subscriber
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
