package com.neptune.itcenter.resources;

import com.neptune.itcenter.entities.RoomEntity;
import com.neptune.itcenter.entities.UserEntity;
import com.neptune.itcenter.services.RoomService;
import com.neptune.itcenter.services.UserService;
import com.neptune.itcenter.util.factories.RoomFactory;
import com.neptune.itcenter.util.factories.UserFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Path("seed")
public class SeedResource {

    @Inject
    private UserFactory userFactory;
    @EJB
    private UserService userService;

    @Inject
    private RoomFactory roomFactory;
    @EJB
    private RoomService roomService;

    @GET
    public Response init() {
        List<UserEntity> userEntities = userFactory.createEntities();
        userService.add(userEntities);
        List<RoomEntity> roomEntities = roomFactory.createEntities();
        roomService.add(roomEntities);
        return Response.ok().build();
    }
}
