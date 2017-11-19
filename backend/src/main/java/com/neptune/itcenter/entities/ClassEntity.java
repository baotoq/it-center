package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = ClassEntity.FIND_ALL, query = "SELECT c FROM ClassEntity c"),
        @NamedQuery(name = ClassEntity.FIND_BY_SUBJECT_ID, query = "SELECT c FROM ClassEntity c WHERE c.subject.id = :subjectId"),
})
public class ClassEntity extends GenericEntity {
    public static final String FIND_ALL = "ClassEntity.findAll";
    public static final String FIND_BY_SUBJECT_ID = "ClassEntity.findBySubjectId";

    @Column
    private String name;
    @Column
    private String lecturer;
    @Column
    private int tuition;
    @Column
    private LocalDateTime startedAt;
    @Column
    private LocalDateTime endedAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "period_id")
    private PeriodEntity period;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public PeriodEntity getPeriod() {
        return period;
    }

    public void setPeriod(PeriodEntity period) {
        this.period = period;
    }
}
