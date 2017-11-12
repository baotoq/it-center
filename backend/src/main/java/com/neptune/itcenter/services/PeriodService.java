package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Period;
import com.neptune.itcenter.entities.PeriodEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PeriodService extends GenericService<PeriodEntity, Period> {
    public PeriodService() {
        super(PeriodEntity.class, Period.class);
    }

    public PeriodEntity findByPeriodOrderAndSequenceType(Period.PeriodOrder periodOrder, Period.SequenceType sequenceType) {
        TypedQuery<PeriodEntity> query = getEntityManager().createNamedQuery(PeriodEntity.FIND_BY_PERIOD_ORDER_AND_SEQUENCE_TYPE, PeriodEntity.class)
                .setParameter("periodOrder", periodOrder)
                .setParameter("sequenceType", sequenceType);
        List<PeriodEntity> results = query.getResultList();
        if (results.isEmpty())
            return null;
        else return results.get(0);
    }

    @Override
    public PeriodEntity toEntity(Period bom) {
        if (bom == null) return null;
        PeriodEntity entity = super.toEntity(bom);
        entity.setSequenceType(bom.getSequenceType());
        entity.setPeriodOrder(bom.getPeriodOrder());
        return entity;
    }

    @Override
    public Period toBom(PeriodEntity entity) {
        if (entity == null) return null;
        Period bom = super.toBom(entity);
        bom.setSequenceType(entity.getSequenceType());
        bom.setPeriodOrder(entity.getPeriodOrder());
        return bom;
    }
}
