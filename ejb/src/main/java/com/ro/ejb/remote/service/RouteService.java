package com.ro.ejb.remote.service;

import jakarta.ejb.Remote;

@Remote
public interface RouteService {

    Boolean planRoute(String origin, String destination);

}
