package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.ClassEntity;

import java.util.ArrayList;
import java.util.List;

public class ClassFactory extends GenericFactory<ClassEntity> {
    @Override
    public List<ClassEntity> createEntities(int amount) {
        List<ClassEntity> entities = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            ClassEntity entity = new ClassEntity();
            entity.setLecturer(faker.name().fullName());
            entity.setCapacity(faker.number().numberBetween(20, 40));
            entity.setLecturer(faker.name().fullName());
            entity.setPrice(faker.number().numberBetween(50000, 100000));
            entity.setActive(faker.bool().bool());
            entity.setSubject(new SubjectFactory().createEntities(1).get(0));
            entity.setRoom(new RoomFactory().createEntities(1).get(0));
            entities.add(entity);
        }
        return entities;
    }
}
