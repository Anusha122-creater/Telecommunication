package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.BillingCycle;
import com.Telecommunication.service.BillingCycleService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class BillingCycleServiceImpl implements BillingCycleService {

  
    private SessionFactory sessionFactory;

    // Get all billing cycles
    @Override
    public List<BillingCycle> getAllBillingCycles() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM BillingCycle", BillingCycle.class).list();
        }
    }

    // Get a billing cycle by ID
    @Override
    public BillingCycle getBillingCycleById(Integer billingCycleId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(BillingCycle.class, billingCycleId);
        }
    }

    // Create a new billing cycle
    @Override
    public void createBillingCycle(BillingCycle billingCycle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(billingCycle); // Save new billing cycle
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

    // Update an existing billing cycle
    @Override
    public void updateBillingCycle(BillingCycle billingCycle) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(billingCycle); // Update existing billing cycle
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

    // Delete a billing cycle
    @Override
    public void deleteBillingCycle(Integer billingCycleId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            BillingCycle billingCycle = session.get(BillingCycle.class, billingCycleId);
            if (billingCycle != null) {
                session.delete(billingCycle); // Delete billing cycle
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

