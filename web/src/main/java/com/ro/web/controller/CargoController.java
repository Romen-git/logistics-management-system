package com.ro.web.controller;

import com.ro.ejb.entity.Cargo;
import com.ro.ejb.remote.dao.CargoDAO;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.util.List;

@Path("/cargo")
public class CargoController {

    @EJB
    private CargoDAO cargoDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCargo(Cargo cargo) {
        cargoDAO.save(cargo);
        return Response.status(Response.Status.CREATED).entity(cargo).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCargoById(@PathParam("id") Long id) {
        Cargo cargo = cargoDAO.findById(id);
        if (cargo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cargo).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cargo> getAllCargo() {
        return cargoDAO.findAll();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCargo(@PathParam("id") Long id, Cargo cargo) {
        cargo.setId(id); // Set the ID of the cargo object
        cargoDAO.update(cargo);
        return Response.ok(cargo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCargo(@PathParam("id") Long id) {
        Cargo cargo = cargoDAO.findById(id);
        if (cargo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cargoDAO.delete(cargo);
        return Response.noContent().build();
    }

}
