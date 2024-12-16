package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.Inventory;
import com.Telecommunication.service.InventoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;


public class InventoryServiceImpl implements InventoryService {

    private SessionFactory sessionFactory;

    // Get all inventory
    @Override
    public List<Inventory> getAllInventory() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Inventory", Inventory.class).list();
        }
    }

    // Get inventory by ID
    @Override
    public Inventory getInventoryById(Integer inventoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Inventory.class, inventoryId);
        }
    }

    // Create a new inventory
    @Override
    public void createInventory(Inventory inventory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(inventory); // Save new inventory
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

    // Update existing inventory
    @Override
    public void updateInventory(Inventory inventory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(inventory); // Update inventory
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

    // Delete inventory
    @Override
    public void deleteInventory(Integer inventoryId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Inventory inventory = session.get(Inventory.class, inventoryId);
            if (inventory != null) {
                session.delete(inventory); // Delete inventory
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
