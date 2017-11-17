package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Subject;
import com.neptune.itcenter.entities.SubjectEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SubjectService extends GenericService<SubjectEntity, Subject> {

    public SubjectService() {
        super(SubjectEntity.class, Subject.class);
    }

    public List<SubjectEntity> findAll() {
        TypedQuery<SubjectEntity> query = getEntityManager().createNamedQuery(SubjectEntity.FIND_ALL, SubjectEntity.class);
        return query.getResultList();
    }

    @Override
    public SubjectEntity toEntity(Subject bom) {
        if (bom == null)
            return null;
        SubjectEntity entity = findById(bom.getId());
        entity.setName(bom.getName());
        entity.setLevel(bom.getLevel());
        return entity;
    }

    @Override
    public Subject toBom(SubjectEntity entity) {
        if (entity == null)
            return null;
        Subject bom = super.toBom(entity);
        bom.setName(entity.getName());
        bom.setLevel(entity.getLevel());
        return bom;
    }
}
