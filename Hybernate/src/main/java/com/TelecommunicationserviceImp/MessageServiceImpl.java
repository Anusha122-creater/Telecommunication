package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.Message;
import com.Telecommunication.service.MessageService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;


public class MessageServiceImpl implements MessageService {

   
    private SessionFactory sessionFactory;

    // Get all messages
    @Override
    public List<Message> getAllMessages() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Message", Message.class).list();
        }
    }

    // Get a message by ID
    @Override
    public Message getMessageById(Integer messageId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Message.class, messageId);
        }
    }

    // Create a new message
    @Override
    public void createMessage(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(message); // Save new message
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

    // Update an existing message
    @Override
    public void updateMessage(Message message) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(message); // Update message
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

    // Delete a message
    @Override
    public void deleteMessage(Integer messageId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Message message = session.get(Message.class, messageId);
            if (message != null) {
                session.delete(message); // Delete message
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
