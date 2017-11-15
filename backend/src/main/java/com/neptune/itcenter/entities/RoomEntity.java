package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
@NamedQueries({
        @NamedQuery(name = RoomEntity.FIND_ALL, query = "SELECT t FROM RoomEntity t"),
})
public class RoomEntity extends GenericEntity implements Serializable {
    public static final String FIND_ALL = "RoomEntity.findAll";
    @Column
    private boolean active;
    @Column
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
