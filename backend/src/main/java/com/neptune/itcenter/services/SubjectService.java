package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Subject;
import com.neptune.itcenter.entities.SubjectEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SubjectService extends GenericService<SubjectEntity, Subject> {

    @EJB
    private ClassService classService;

    public SubjectService() {
        super(SubjectEntity.class);
    }

    public List<SubjectEntity> findAll() {
        TypedQuery<SubjectEntity> query = getEntityManager().createNamedQuery(SubjectEntity.FIND_ALL, SubjectEntity.class);
        return query.getResultList();
    }

    public SubjectEntity update(Subject bom) {
        SubjectEntity entity = findById(bom.getId());
        entity.setName(bom.getName());
        entity.setActive(bom.isActive());
        return super.update(entity);
    }

    @Override
    public SubjectEntity toEntity(Subject bom) {
        if (bom == null)
            return null;
        SubjectEntity entity = new SubjectEntity();
        entity.setId(bom.getId());
        entity.setName(bom.getName());
        entity.setActive(bom.isActive());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeletedAt(bom.getDeleteAt());
        return entity;
    }

    @Override
    public Subject toBom(SubjectEntity entity) {
        if (entity == null)
            return null;
        Subject bom = new Subject();
        bom.setId(entity.getId());
        bom.setName(entity.getName());
        bom.setActive(entity.isActive());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeleteAt(entity.getDeletedAt());
        return bom;
    }
}
