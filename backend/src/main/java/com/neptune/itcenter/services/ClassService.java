package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Class;
import com.neptune.itcenter.entities.ClassEntity;

public class ClassService extends GenericService<ClassEntity, Class> {

    public ClassService() {
        super(ClassEntity.class);
    }

    @Override
    public ClassEntity toEntity(Class bom) {
        return null;
    }

    @Override
    public Class toBom(ClassEntity entity) {
        return null;
    }
}
