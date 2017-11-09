package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.SubjectEntity;

import java.util.ArrayList;
import java.util.List;

public class SubjectFactory extends GenericFactory<SubjectEntity> {

    @Override
    public List<SubjectEntity> createEntities(int amount) {
        List<SubjectEntity> entities = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            SubjectEntity entity = new SubjectEntity();
            entity.setName(faker.educator().course());
            entity.setPrice(faker.number().numberBetween(500000, 1000000));
            entity.setActive(faker.bool().bool());
            entities.add(entity);
        }
        return entities;
    }
}
