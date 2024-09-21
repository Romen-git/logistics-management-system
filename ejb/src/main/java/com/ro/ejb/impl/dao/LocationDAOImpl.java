package com.ro.ejb.impl.dao;

import com.ro.ejb.entity.InventoryItem;
import com.ro.ejb.entity.Location;
import com.ro.ejb.remote.dao.LocationDAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class LocationDAOImpl implements LocationDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Location findById(Long id) {
        return entityManager.find(Location.class, id);
    }

    @Override
    public List<Location> findAll() {
        return entityManager.createQuery("SELECT l FROM Location l", Location.class).getResultList();
    }

    @Override
    public Boolean save(Location location) {
        try {
            entityManager.persist(location);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(Location location) {
        try {
            entityManager.merge(location);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(Location location) {
        try {
            if (entityManager.contains(location)) {
                entityManager.remove(location);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
