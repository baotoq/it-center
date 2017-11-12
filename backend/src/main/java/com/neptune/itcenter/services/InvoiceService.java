package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Invoice;
import com.neptune.itcenter.entities.InvoiceEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class InvoiceService extends GenericService<InvoiceEntity, Invoice> {
    public InvoiceService() {
        super(InvoiceEntity.class, Invoice.class);
    }

    public List<InvoiceEntity> findAll() {
        TypedQuery<InvoiceEntity> query = getEntityManager().createNamedQuery(InvoiceEntity.FIND_ALL, InvoiceEntity.class);
        return query.getResultList();
    }

    public InvoiceEntity update(Invoice bom) {
        InvoiceEntity entity = findById(bom.getId());
        return super.update(entity);
    }

    @Override
    public InvoiceEntity toEntity(Invoice bom) {
        if (bom == null)
            return null;
        InvoiceEntity entity = new InvoiceEntity();
        entity.setId(bom.getId());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        entity.setDeletedAt(bom.getDeletedAt());
        return entity;
    }

    @Override
    public Invoice toBom(InvoiceEntity entity) {
        if (entity == null)
            return null;
        Invoice bom = new Invoice();
        bom.setId(entity.getId());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeletedAt(entity.getDeletedAt());
        return bom;
    }
}
