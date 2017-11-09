package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = ClassEntity.FIND_ALL, query = "SELECT t FROM ClassEntity t"),
})
public class ClassEntity extends GenericEntity {
    public static final String FIND_ALL = "ClassEntity.findAll";

    @Column
    private String lecturer;
    @Column
    private int capacity;
    @Column
    private int price;
    @Column
    private boolean active;
    @Column
    private LocalDateTime startedAt;
    @Column
    private LocalDateTime endedAt;

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
}
