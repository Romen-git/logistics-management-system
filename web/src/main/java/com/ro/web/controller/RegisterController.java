package com.ro.web.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/register")
public class RegisterController {

    @GET
    public Viewable index() {

        return new Viewable("/frontend/auth/register");
    }

}
