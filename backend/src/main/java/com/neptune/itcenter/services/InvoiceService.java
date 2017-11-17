package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Invoice;
import com.neptune.itcenter.entities.InvoiceEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InvoiceService extends GenericService<InvoiceEntity, Invoice> {
    @EJB
    private UserService userService;

    public InvoiceService() {
        super(InvoiceEntity.class, Invoice.class);
    }

    public List<InvoiceEntity> findAll() {
        TypedQuery<InvoiceEntity> query = getEntityManager().createNamedQuery(InvoiceEntity.FIND_ALL, InvoiceEntity.class);
        return query.getResultList();
    }

    @Override
    public InvoiceEntity update(InvoiceEntity bom) {
        InvoiceEntity entity = findById(bom.getId());
        entity.setTotal(bom.getTotal());
        entity.setStudent(bom.getStudent());
        return super.update(entity);
    }

    @Override
    public InvoiceEntity toEntity(Invoice bom) {
        if (bom == null)
            return null;
        InvoiceEntity entity = findById(bom.getId());
        entity.setTotal(bom.getTotal());
        entity.setConfirmed(bom.isConfirmed());
        entity.setStudent(userService.toEntity(bom.getStudent()));
        return entity;
    }

    @Override
    public Invoice toBom(InvoiceEntity entity) {
        if (entity == null)
            return null;
        Invoice bom = super.toBom(entity);
        bom.setTotal(entity.getTotal());
        bom.setConfirmed(entity.isConfirmed());
        bom.setStudent(userService.toBom(entity.getStudent()));
        return bom;
    }
}
