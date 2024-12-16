package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.Call;
import com.Telecommunication.service.CallService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;


public class CallServiceImpl implements CallService {

   
    private SessionFactory sessionFactory;

    // Get all calls
    @Override
    public List<Call> getAllCalls() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Call", Call.class).list();
        }
    }

    // Get a call by ID
    @Override
    public Call getCallById(Integer callId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Call.class, callId);
        }
    }

    // Create a new call record
    @Override
    public void createCall(Call call) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(call); // Save new call record
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

    // Update an existing call record
    @Override
    public void updateCall(Call call) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(call); // Update existing call record
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

    // Delete a call record
    @Override
    public void deleteCall(Integer callId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Call call = session.get(Call.class, callId);
            if (call != null) {
                session.delete(call); // Delete call record
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
