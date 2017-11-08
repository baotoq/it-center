package com.neptune.itcenter.entities;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = ClassEntity.FIND_ALL, query = "SELECT t FROM ClassEntity t"),
})
public class ClassEntity extends GenericEntity {
    public static final String FIND_ALL = "ClassEntity.findAll";

    @Column
    private String name;
    @Column
    private String lecturer;
    @Column
    private int capacity;
    @Column
    private int price;
    @Column
    private boolean active;

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
}
