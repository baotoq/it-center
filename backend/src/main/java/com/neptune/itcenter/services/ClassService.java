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
    private SubjectService subjectService;
    @EJB
    private RoomService roomService;
    @EJB
    private PeriodService periodService;

    public ClassService() {
        super(ClassEntity.class, Class.class);
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
        return super.update(entity);
    }

    @Override
    public ClassEntity toEntity(Class bom) {
        if (bom == null)
            return null;
        ClassEntity entity = super.toEntity(bom);
        entity.setName(bom.getName());
        entity.setCapacity(bom.getCapacity());
        entity.setActive(bom.isActive());
        entity.setLecturer(bom.getLecturer());
        entity.setPrice(bom.getPrice());
        entity.setActive(bom.isActive());
        entity.setStartedAt(bom.getStartedAt());
        entity.setEndedAt(bom.getEndedAt());
        return entity;
    }

    @Override
    public Class toBom(ClassEntity entity) {
        if (entity == null)
            return null;
        Class bom = super.toBom(entity);
        bom.setName(entity.getName());
        bom.setCapacity(entity.getCapacity());
        bom.setActive(entity.isActive());
        bom.setLecturer(entity.getLecturer());
        bom.setPrice(entity.getPrice());
        bom.setStartedAt(entity.getStartedAt());
        bom.setEndedAt(entity.getEndedAt());
        bom.setActive(entity.isActive());
        bom.setSubject(subjectService.toBom(entity.getSubject()));
        bom.setRoom(roomService.toBom(entity.getRoom()));
        bom.setPeriod(periodService.toBom(entity.getPeriod()));
        return bom;
    }
}
