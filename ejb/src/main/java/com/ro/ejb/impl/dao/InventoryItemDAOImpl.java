package com.ro.ejb.impl.dao;

import com.ro.ejb.entity.Cargo;
import com.ro.ejb.entity.InventoryItem;
import com.ro.ejb.remote.dao.InventoryItemDAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class InventoryItemDAOImpl implements InventoryItemDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public InventoryItem findById(Long id) {
        return entityManager.find(InventoryItem.class, id);
    }

    @Override
    public List<InventoryItem> findAll() {
        return entityManager.createQuery("SELECT i FROM InventoryItem i", InventoryItem.class).getResultList();
    }

    @Override
    public Boolean save(InventoryItem inventoryItem) {
        try {
            entityManager.persist(inventoryItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean update(InventoryItem inventoryItem) {
        try {
            entityManager.merge(inventoryItem);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean delete(InventoryItem inventoryItem) {
        try {
            if (entityManager.contains(inventoryItem)) {
                entityManager.remove(inventoryItem);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
