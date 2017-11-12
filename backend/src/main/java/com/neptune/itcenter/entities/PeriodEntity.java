package com.neptune.itcenter.entities;

import com.neptune.itcenter.boms.Period.PeriodOrder;
import com.neptune.itcenter.boms.Period.SequenceType;

import javax.persistence.*;

@Entity
@Table(name = "periods")
@NamedQueries({
        @NamedQuery(name = PeriodEntity.FIND_BY_PERIOD_ORDER_AND_SEQUENCE_TYPE, query = "SELECT p FROM PeriodEntity p WHERE p.periodOrder = :periodOrder AND p.sequenceType = :sequenceType"),
})
public class PeriodEntity extends GenericEntity {
    public static final String FIND_BY_PERIOD_ORDER_AND_SEQUENCE_TYPE = "PeriodEntity.findByPeriodOrderAndSequenceType";

    @Enumerated(EnumType.STRING)
    private PeriodOrder periodOrder;

    @Enumerated(EnumType.STRING)
    private SequenceType sequenceType;

    public PeriodEntity() {
    }

    public PeriodEntity(PeriodOrder periodOrder, SequenceType sequenceType) {
        this.periodOrder = periodOrder;
        this.sequenceType = sequenceType;
    }

    public boolean isConflictedWith(PeriodEntity obj) {
        return this.sequenceType == obj.sequenceType && this.periodOrder == obj.periodOrder;
    }

    public SequenceType getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(SequenceType sequenceType) {
        this.sequenceType = sequenceType;
    }

    public PeriodOrder getPeriodOrder() {
        return periodOrder;
    }

    public void setPeriodOrder(PeriodOrder periodOrder) {
        this.periodOrder = periodOrder;
    }
}
