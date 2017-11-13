package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.User;
import com.neptune.itcenter.entities.UserEntity;
import com.neptune.itcenter.services.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Stateless
@Path("users")
public class UserResource extends GenericResource {

    @EJB
    private UserService userService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User get(@PathParam("id") Integer id) {
        UserEntity userEntity = userService.findById(id);
        return userService.toBom(userEntity);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<User> getAll() {
        List<UserEntity> userEntities = userService.findAll();
        return userService.toBoms(userEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid User user) {
        UserEntity userEntity = userService.add(user);
        URI createdUri = appendCurrentUriWith(String.valueOf(userEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, @Valid User user) {
        user.setId(id);
        userService.update(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        UserEntity userEntity = userService.findById(id);
        userService.delete(userEntity);
        return Response.noContent().build();
    }

    @POST
    @Path("auth")
    public Response auth(User user) {
        if (userService.authenticate(user.getUsername(), user.getPassword())) {
            UserEntity userEntity = userService.findByUsername(user.getUsername());
            return Response.ok().entity(userService.toBom(userEntity)).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
