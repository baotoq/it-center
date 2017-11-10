package com.neptune.itcenter.services;

import com.neptune.itcenter.entities.ClassEntity;
import com.neptune.itcenter.entities.RoomEntity;
import com.neptune.itcenter.entities.SubjectEntity;
import com.neptune.itcenter.entities.UserEntity;
import com.neptune.itcenter.util.factories.ClassFactory;
import com.neptune.itcenter.util.factories.RoomFactory;
import com.neptune.itcenter.util.factories.SubjectFactory;
import com.neptune.itcenter.util.factories.UserFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

@Singleton
@Startup
public class SeedService {
    private static final int USER_AMOUNT = 30;
    private static final int SUBJECT_AMOUNT = 20;
    private static final int CLASS_AMOUNT = 20;
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

    @Inject
    private ClassFactory classFactory;
    @EJB
    private ClassService classService;

    @PostConstruct
    public void init() {
        List<UserEntity> userEntities = userFactory.createEntities(USER_AMOUNT);
        userEntities.get(0).setUsername("admin");
        userService.add(userEntities);
        List<RoomEntity> roomEntities = roomFactory.createEntities(ROOM_AMOUNT);
        roomService.add(roomEntities);
        List<SubjectEntity> subjectEntities = subjectFactory.createEntities(SUBJECT_AMOUNT);
        subjectService.add(subjectEntities);
        List<ClassEntity> classEntities = classFactory.createEntities(CLASS_AMOUNT);
        classService.add(classEntities);
    }
}
