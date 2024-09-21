package com.ro.ejb.impl.dao;

import com.ro.ejb.entity.Location;
import com.ro.ejb.entity.Shipment;
import com.ro.ejb.remote.dao.ShipmentDAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ShipmentDAOImpl implements ShipmentDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Shipment findById(Long id) {
        return entityManager.find(Shipment.class, id);
    }

    @Override
    public List<Shipment> findAll() {
        return entityManager.createQuery("SELECT s FROM Shipment s", Shipment.class).getResultList();
    }

    @Override
    public Boolean save(Shipment shipment) {
        try {
            entityManager.persist(shipment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Shipment shipment) {
        try {
            entityManager.merge(shipment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Shipment shipment) {
        try {
            if (entityManager.contains(shipment)) {
                entityManager.remove(shipment);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
