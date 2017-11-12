package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Registration;
import com.neptune.itcenter.entities.RegistrationEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class RegistrationService extends GenericService<RegistrationEntity, Registration> {
    public RegistrationService() {
        super(RegistrationEntity.class, Registration.class);
    }

    public List<RegistrationEntity> findAll() {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL, RegistrationEntity.class);
        return query.getResultList();
    }

    @Override
    public RegistrationEntity toEntity(Registration bom) {
        if (bom == null) return null;
        RegistrationEntity entity = new RegistrationEntity();
        entity.setAbsent(bom.getAbsent());
        entity.setLate(bom.getLate());
        entity.setGrade(bom.getGrade());
        return entity;
    }

    @Override
    public Registration toBom(RegistrationEntity entity) {
        if (entity == null) return null;
        Registration bom = new Registration();
        bom.setAbsent(entity.getAbsent());
        bom.setLate(entity.getLate());
        bom.setGrade(entity.getGrade());
        return bom;
    }
}
