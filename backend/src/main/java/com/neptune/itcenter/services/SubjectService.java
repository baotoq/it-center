package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Subject;
import com.neptune.itcenter.entities.SubjectEntity;

public class SubjectService extends GenericService<SubjectEntity, Subject> {

    public SubjectService() {
        super(SubjectEntity.class);
    }

    @Override
    public SubjectEntity toEntity(Subject bom) {
        return null;
    }

    @Override
    public Subject toBom(SubjectEntity entity) {
        return null;
    }
}
