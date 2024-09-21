package com.ro.web.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/login")
public class LoginController {

    @GET
    public Viewable index() {

        return new Viewable("/frontend/auth/login");
    }

}
