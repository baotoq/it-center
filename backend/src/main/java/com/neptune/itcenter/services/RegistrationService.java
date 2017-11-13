package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Registration;
import com.neptune.itcenter.entities.RegistrationEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RegistrationService extends GenericService<RegistrationEntity, Registration> {

    @EJB
    private ClassService classService;

    public RegistrationService() {
        super(RegistrationEntity.class, Registration.class);
    }

    public List<RegistrationEntity> findAll() {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL, RegistrationEntity.class);
        return query.getResultList();
    }

    public List<RegistrationEntity> findAllByStudentId(int id) {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL_BY_STUDENT_ID, RegistrationEntity.class);
        query.setParameter("studentId", id);
        return query.getResultList();
    }

    public List<RegistrationEntity> findAllByClassId(int id) {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL_BY_CLASS_ID, RegistrationEntity.class);
        query.setParameter("classId", id);
        return query.getResultList();
    }

    @Override
    public RegistrationEntity toEntity(Registration bom) {
        if (bom == null) return null;
        RegistrationEntity entity = super.toEntity(bom);
        entity.setAbsent(bom.getAbsent());
        entity.setLate(bom.getLate());
        entity.setGrade(bom.getGrade());
        return entity;
    }

    @Override
    public Registration toBom(RegistrationEntity entity) {
        if (entity == null) return null;
        Registration bom = super.toBom(entity);
        bom.setAbsent(entity.getAbsent());
        bom.setLate(entity.getLate());
        bom.setGrade(entity.getGrade());
        bom.setAttendedClass(classService.toBom(entity.getAttendedClass()));
        return bom;
    }
}
