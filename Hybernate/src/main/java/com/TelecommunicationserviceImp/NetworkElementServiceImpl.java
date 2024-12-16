package com.TelecommunicationserviceImp;

import com.Telecommunication.entity.NetworkElement;
import com.Telecommunication.service.NetworkElementService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class NetworkElementServiceImpl implements NetworkElementService {

 
    private SessionFactory sessionFactory;

    // Get all network elements
    @Override
    public List<NetworkElement> getAllNetworkElements() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM NetworkElement", NetworkElement.class).list();
        }
    }

    // Get a network element by ID
    @Override
    public NetworkElement getNetworkElementById(Integer networkElementId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(NetworkElement.class, networkElementId);
        }
    }

    // Create a new network element
    @Override
    public void createNetworkElement(NetworkElement networkElement) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(networkElement); // Save new network element
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

    // Update an existing network element
    @Override
    public void updateNetworkElement(NetworkElement networkElement) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(networkElement); // Update network element
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

    // Delete a network element
    @Override
    public void deleteNetworkElement(Integer networkElementId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            NetworkElement networkElement = session.get(NetworkElement.class, networkElementId);
            if (networkElement != null) {
                session.delete(networkElement); // Delete network element
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
