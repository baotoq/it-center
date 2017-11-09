package com.neptune.itcenter.resources;

import com.neptune.itcenter.entities.RoomEntity;
import com.neptune.itcenter.entities.SubjectEntity;
import com.neptune.itcenter.entities.UserEntity;
import com.neptune.itcenter.services.RoomService;
import com.neptune.itcenter.services.SubjectService;
import com.neptune.itcenter.services.UserService;
import com.neptune.itcenter.util.factories.RoomFactory;
import com.neptune.itcenter.util.factories.SubjectFactory;
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
    private static final int USER_AMOUNT = 30;
    private static final int SUBJECT_AMOUNT = 20;
    private static final int CLASS_AMOUNT = 40;
    private static final int ROOM_AMOUNT = 20;

    @Inject
    private UserFactory userFactory;
    @EJB
    private UserService userService;

    @Inject
    private RoomFactory roomFactory;
    @EJB
    private RoomService roomService;

    @Inject
    private SubjectFactory subjectFactory;
    @EJB
    private SubjectService subjectService;

    @GET
    public Response init() {
        List<UserEntity> userEntities = userFactory.createEntities(USER_AMOUNT);
        userService.add(userEntities);
        List<RoomEntity> roomEntities = roomFactory.createEntities(ROOM_AMOUNT);
        roomService.add(roomEntities);
        List<SubjectEntity> subjectEntities = subjectFactory.createEntities(SUBJECT_AMOUNT);
        subjectService.add(subjectEntities);
        return Response.ok().build();
    }
}
