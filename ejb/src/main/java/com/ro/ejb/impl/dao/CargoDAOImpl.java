package com.ro.ejb.impl.dao;

import com.ro.ejb.entity.Cargo;
import com.ro.ejb.remote.dao.CargoDAO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CargoDAOImpl implements CargoDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Cargo findById(Long id) {
        return entityManager.find(Cargo.class, id);
    }

    @Override
    public List<Cargo> findAll() {
        return entityManager.createQuery("SELECT c FROM Cargo c", Cargo.class).getResultList();
    }

    @Override
    @RolesAllowed({"superadmin","admin"})
    public Boolean save(Cargo cargo) {
        try {
            entityManager.persist(cargo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    @RolesAllowed({"superadmin","admin"})
    public Boolean update(Cargo cargo) {
        try {
            entityManager.merge(cargo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @RolesAllowed({"superadmin","admin"})
    public Boolean delete(Cargo cargo) {
        try {
            if (entityManager.contains(cargo)) {
                entityManager.remove(cargo);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
