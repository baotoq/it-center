package com.neptune.itcenter.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("users")
public class UserResource {

    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    public Response get() {
        return Response.ok().build();
    }
}
