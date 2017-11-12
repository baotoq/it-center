package com.neptune.itcenter.services;

import com.neptune.itcenter.entities.*;
import com.neptune.itcenter.util.factories.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.List;

@Singleton
@Startup
public class SeedService {
    private static final int USER_AMOUNT = 30;
    private static final int ROOM_AMOUNT = 20;
    private static final int SUBJECT_AMOUNT = 20;
    private static final int PERIOD_AMONT = 10;
    private static final int CLASS_AMOUNT = 20;

    @EJB
    private UserService userService;
    @EJB
    private RoomService roomService;
    @EJB
    private SubjectService subjectService;
    @EJB
    private PeriodService periodService;
    @EJB
    private ClassService classService;

    @PostConstruct
    public void init() {
        List<UserEntity> userEntities = new UserFactory(USER_AMOUNT).createEntities();
        userEntities.get(0).setUsername("admin");
        userService.add(userEntities);
        List<RoomEntity> roomEntities = new RoomFactory(ROOM_AMOUNT).createEntities();
        roomService.add(roomEntities);
        List<SubjectEntity> subjectEntities = new SubjectFactory(SUBJECT_AMOUNT).createEntities();
        subjectService.add(subjectEntities);
        List<PeriodEntity> periodEntities = new PeriodFactory().createEntities();
        periodService.add(periodEntities);
        List<ClassEntity> classEntities = new ClassFactory(CLASS_AMOUNT, periodEntities, roomEntities, subjectEntities).createEntities();
        classService.add(classEntities);
    }
}
