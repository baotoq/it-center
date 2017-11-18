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
    @EJB
    private InvoiceService invoiceService;

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

    public List<RegistrationEntity> findAllByInvoiceId(int id) {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL_BY_INVOICE_ID, RegistrationEntity.class);
        query.setParameter("invoiceId", id);
        return query.getResultList();
    }

    public List<RegistrationEntity> findAllByClassId(int id) {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_ALL_BY_CLASS_ID, RegistrationEntity.class);
        query.setParameter("classId", id);
        return query.getResultList();
    }

    public List<RegistrationEntity> findConfirmedByClassId(int id) {
        TypedQuery<RegistrationEntity> query = getEntityManager().createNamedQuery(RegistrationEntity.FIND_CONFIRMED_BY_CLASS_ID, RegistrationEntity.class);
        query.setParameter("classId", id);
        return query.getResultList();
    }

    @Override
    public RegistrationEntity toEntity(Registration bom) {
        if (bom == null) return null;
        RegistrationEntity entity = findById(bom.getId());
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
        bom.setInvoice(invoiceService.toBom(entity.getInvoice()));
        return bom;
    }
}
