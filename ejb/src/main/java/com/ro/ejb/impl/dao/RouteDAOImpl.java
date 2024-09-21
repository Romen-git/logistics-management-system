package com.ro.ejb.impl.dao;

import com.ro.ejb.entity.Route;
import com.ro.ejb.remote.dao.RouteDAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RouteDAOImpl implements RouteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean createRoute(Route route) {
        em.persist(route);
        return true;
    }

    @Override
    public Route findRouteById(Long id) {
        return em.find(Route.class, id);
    }

    @Override
    public List<Route> getAllRoutes() {
        return em.createQuery("SELECT r FROM Route r", Route.class).getResultList();
    }
}
