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
    @EJB
    private RegistrationService registrationService;

    public ClassService() {
        super(ClassEntity.class, Class.class);
    }

    public List<ClassEntity> findAll() {
        TypedQuery<ClassEntity> query = getEntityManager().createNamedQuery(ClassEntity.FIND_ALL, ClassEntity.class);
        return query.getResultList();
    }

    @Override
    public ClassEntity toEntity(Class bom) {
        if (bom == null)
            return null;
        ClassEntity entity = findById(bom.getId());
        entity.setName(bom.getName());
        entity.setLecturer(bom.getLecturer());
        entity.setPrice(bom.getPrice());
        entity.setStartedAt(bom.getStartedAt());
        entity.setEndedAt(bom.getEndedAt());
        entity.setPeriod(periodService.toEntity(bom.getPeriod()));
        entity.setSubject(subjectService.findById(bom.getSubject().getId()));
        entity.setRoom(roomService.findById(bom.getRoom().getId()));
        return entity;
    }

    @Override
    public Class toBom(ClassEntity entity) {
        if (entity == null)
            return null;
        Class bom = super.toBom(entity);
        bom.setName(entity.getName());
        bom.setLecturer(entity.getLecturer());
        bom.setPrice(entity.getPrice());
        bom.setStartedAt(entity.getStartedAt());
        bom.setEndedAt(entity.getEndedAt());
        bom.setSubject(subjectService.toBom(entity.getSubject()));
        bom.setRoom(roomService.toBom(entity.getRoom()));
        bom.setPeriod(periodService.toBom(entity.getPeriod()));
        bom.setNumberOfStudents(registrationService.findAllByClassId(entity.getId()).size());
        return bom;
    }
}
