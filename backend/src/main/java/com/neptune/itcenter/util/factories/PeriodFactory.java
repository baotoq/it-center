package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.boms.Period;
import com.neptune.itcenter.entities.PeriodEntity;

import java.util.ArrayList;
import java.util.List;

public class PeriodFactory extends GenericFactory<PeriodEntity> {
    public PeriodFactory() {
        super(0);
    }

    @Override
    public List<PeriodEntity> createEntities() {
        List<PeriodEntity> entities = new ArrayList<>();
        for (Period.SequenceType sequenceType : Period.SequenceType.values()) {
            for (Period.PeriodOrder periodOrder : Period.PeriodOrder.values()) {
                entities.add(new PeriodEntity(periodOrder, sequenceType));
            }
        }
        return entities;
    }
}
