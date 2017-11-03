package com.neptune.resources;

import com.neptune.services.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    @Path("getAll")
    public String getAll() {
        return userService.getAll();
    }
}
