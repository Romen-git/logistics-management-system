package com.ro.ejb.impl.service;

import com.ro.ejb.entity.Route;
import com.ro.ejb.remote.dao.RouteDAO;
import com.ro.ejb.remote.service.RouteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class RouteServiceImpl implements RouteService {

    @EJB
    private RouteDAO routeDAO;

    @Override
    public Boolean planRoute(String origin, String destination) {
        // Logic for route planning and optimization
        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setDistance(100);//calculateDistance(origin,destination)
        routeDAO.createRoute(route);
        return true;
    }
}
