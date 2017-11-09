package com.neptune.itcenter.resources;

import com.neptune.itcenter.boms.Room;
import com.neptune.itcenter.entities.RoomEntity;
import com.neptune.itcenter.services.RoomService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Stateless
@Path("rooms")
public class RoomResource {
    @EJB
    private RoomService roomService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Room get(@PathParam("id") Integer id) {
        RoomEntity roomEntity = roomService.findById(id);
        return roomService.toBom(roomEntity);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Room> getAll() {
        List<RoomEntity> roomEntities = roomService.findAll();
        return roomService.toBoms(roomEntities);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response add(@Valid Room room) {
        RoomEntity roomEntity = roomService.add(room);
        URI createdUri = appendCurrentUriWith(String.valueOf(roomEntity.getId()));
        return Response.created(createdUri).type(MediaType.APPLICATION_JSON).location(createdUri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, @Valid Room room) {
        room.setId(id);
        roomService.update(room);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Integer id) {
        RoomEntity roomEntity = roomService.findById(id);
        roomService.delete(roomEntity);
        return Response.noContent().build();
    }

    private URI appendCurrentUriWith(String fragment) {
        return uriInfo.getAbsolutePathBuilder().path(fragment).build();
    }
}
