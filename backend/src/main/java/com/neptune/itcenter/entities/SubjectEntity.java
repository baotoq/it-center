package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subjects")
@NamedQueries({
        @NamedQuery(name = SubjectEntity.FIND_ALL, query = "SELECT t FROM SubjectEntity t"),
})
public class SubjectEntity extends GenericEntity implements Serializable {
    public static final String FIND_ALL = "SubjectEntity.findAll";

    @Column
    private String name;
    @Column
    private boolean active;

    public SubjectEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
