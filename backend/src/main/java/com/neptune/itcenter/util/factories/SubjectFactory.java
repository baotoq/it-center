package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.SubjectEntity;

import java.util.ArrayList;
import java.util.List;

public class SubjectFactory extends GenericFactory<SubjectEntity> {
    public SubjectFactory(int amount) {
        super(amount);
    }

    @Override
    public List<SubjectEntity> createEntities() {
        List<SubjectEntity> entities = new ArrayList<>();

        for (int i = 0; i < getAmount(); i++) {
            SubjectEntity entity = new SubjectEntity();
            entity.setName(faker.name().firstName());
            entities.add(entity);
        }
        return entities;
    }
}
