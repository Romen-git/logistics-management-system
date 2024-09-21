package com.ro.web.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/")
public class DashboardController {

    @GET
    @Path("/dashboard")
    public Viewable dashboard() {
        return new Viewable("/frontend/dashboard");
    }

}
