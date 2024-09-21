package com.ro.web.controller;

import com.ro.ejb.entity.User;
import com.ro.ejb.remote.service.UserService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserController {

    @EJB
    private UserService userService;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(User user) {
        userService.registerUser(user.getPassword(), user.getEmail(), user.getName(), user.getPhoneNumber(), user.getRole());
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(User loginDetails) {
        Boolean loginSuccess = userService.loginUser(loginDetails.getPassword(), loginDetails.getEmail());
        if (loginSuccess) {
            return Response.ok().entity(loginDetails).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
