package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.Payment;
import com.Telecommunication.service.PaymentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;


public class PaymentServiceImpl implements PaymentService {

   
    private SessionFactory sessionFactory;

    // Get all payments
    @Override
    public List<Payment> getAllPayments() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Payment", Payment.class).list();
        }
    }

    // Get payment by ID
    @Override
    public Payment getPaymentById(Integer paymentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Payment.class, paymentId);
        }
    }

    // Create a new payment
    @Override
    public void createPayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payment); // Save new payment
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

    // Update an existing payment
    @Override
    public void updatePayment(Payment payment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(payment); // Update payment
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

    // Delete a payment
    @Override
    public void deletePayment(Integer paymentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, paymentId);
            if (payment != null) {
                session.delete(payment); // Delete payment
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
