package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Class;
import com.neptune.itcenter.entities.ClassEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ClassService extends GenericService<ClassEntity, Class> {

    @EJB
    SubjectService subjectService;
    @EJB
    RoomService roomService;

    public ClassService() {
        super(ClassEntity.class);
    }

    public List<ClassEntity> findAll() {
        TypedQuery<ClassEntity> query = getEntityManager().createNamedQuery(ClassEntity.FIND_ALL, ClassEntity.class);
        return query.getResultList();
    }

    public ClassEntity update(Class bom) {
        ClassEntity entity = findById(bom.getId());
        entity.setId(bom.getId());
        entity.setCapacity(bom.getCapacity());
        entity.setActive(bom.isActive());
        entity.setLecturer(bom.getLecturer());
        entity.setPrice(bom.getPrice());
        entity.setActive(bom.isActive());
        entity.setStartedAt(bom.getStartedAt());
        entity.setEndedAt(bom.getEndedAt());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeletedAt(bom.getDeleteAt());
        return super.update(entity);
    }

    @Override
    public ClassEntity toEntity(Class bom) {
        if (bom == null)
            return null;
        ClassEntity entity = new ClassEntity();
        entity.setId(bom.getId());
        entity.setCapacity(bom.getCapacity());
        entity.setActive(bom.isActive());
        entity.setLecturer(bom.getLecturer());
        entity.setPrice(bom.getPrice());
        entity.setActive(bom.isActive());
        entity.setStartedAt(bom.getStartedAt());
        entity.setEndedAt(bom.getEndedAt());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeletedAt(bom.getDeleteAt());
        return entity;
    }

    @Override
    public Class toBom(ClassEntity entity) {
        if (entity == null)
            return null;
        Class bom = new Class();
        bom.setId(entity.getId());
        bom.setCapacity(entity.getCapacity());
        bom.setActive(entity.isActive());
        bom.setLecturer(entity.getLecturer());
        bom.setPrice(entity.getPrice());
        bom.setStartedAt(entity.getStartedAt());
        bom.setEndedAt(entity.getEndedAt());
        bom.setActive(entity.isActive());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeleteAt(entity.getDeletedAt());
        bom.setSubject(subjectService.toBom(entity.getSubject()));
        bom.setRoom(roomService.toBom(entity.getRoom()));
        return bom;
    }
}
