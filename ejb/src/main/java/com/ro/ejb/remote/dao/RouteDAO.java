package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.Route;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface RouteDAO {

    Boolean createRoute(Route route);

    Route findRouteById(Long id);

    List<Route> getAllRoutes();

}
