package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.ClassEntity;
import com.neptune.itcenter.entities.PeriodEntity;
import com.neptune.itcenter.entities.RoomEntity;
import com.neptune.itcenter.entities.SubjectEntity;

import java.util.ArrayList;
import java.util.List;

public class ClassFactory extends GenericFactory<ClassEntity> {
    private List<PeriodEntity> periods;
    private List<RoomEntity> rooms;
    private List<SubjectEntity> subjects;

    public ClassFactory(int amount, List<PeriodEntity> periods, List<RoomEntity> rooms, List<SubjectEntity> subjects) {
        super(amount);
        this.periods = periods;
        this.rooms = rooms;
        this.subjects = subjects;
    }

    @Override
    public List<ClassEntity> createEntities() {
        List<ClassEntity> entities = new ArrayList<>();
        for (int i = 0; i < getAmount(); i++) {
            ClassEntity entity = new ClassEntity();
            entity.setLecturer(faker.name().fullName());
            entity.setCapacity(faker.number().numberBetween(20, 40));
            entity.setLecturer(faker.name().fullName());
            entity.setPrice(faker.number().numberBetween(50000, 100000));
            entity.setActive(faker.bool().bool());
            entity.setSubject(subjects.get(faker.random().nextInt(subjects.size())));
            entity.setRoom(rooms.get(faker.random().nextInt(rooms.size())));
            entity.setPeriod(periods.get(faker.random().nextInt(periods.size())));
            entities.add(entity);
        }
        return entities;
    }
}
