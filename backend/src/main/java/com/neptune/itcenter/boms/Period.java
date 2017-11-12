package com.neptune.itcenter.boms;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Objects;

public class Period extends Bom {

    @NotNull
    private PeriodOrder periodOrder;

    @NotNull
    private SequenceType sequenceType;

    public PeriodOrder getPeriodOrder() {
        return periodOrder;
    }

    public void setPeriodOrder(PeriodOrder periodOrder) {
        this.periodOrder = periodOrder;
    }

    public SequenceType getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(SequenceType sequenceType) {
        this.sequenceType = sequenceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Period))
            return false;
        Period period = (Period) o;
        return periodOrder == period.periodOrder &&
                sequenceType == period.sequenceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodOrder, sequenceType);
    }

    public enum SequenceType {
        ODD_DAYS("3-5-7"),
        EVEN_DAYS("2-4-6");

        private final String sequence;

        SequenceType(String sequence) {
            this.sequence = sequence;
        }

        public String getSequence() {
            return sequence;
        }
    }

    public enum PeriodOrder {
        FIRST(LocalTime.of(6, 50), LocalTime.of(9, 15)),
        SECOND(LocalTime.of(9, 25), LocalTime.of(11, 50)),
        THIRD(LocalTime.of(12, 30), LocalTime.of(14, 55)),
        FOURTH(LocalTime.of(15, 5), LocalTime.of(17, 30)),
        FIFTH(LocalTime.of(17, 45), LocalTime.of(21, 0));

        private transient LocalTime start;

        private transient LocalTime end;

        PeriodOrder(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        public LocalTime getStartTime() {
            return start;
        }

        public LocalTime getEndTime() {
            return end;
        }
    }
}
