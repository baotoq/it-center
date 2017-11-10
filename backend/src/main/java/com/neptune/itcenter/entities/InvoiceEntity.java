package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = InvoiceEntity.FIND_ALL, query = "SELECT t FROM InvoiceEntity t"),
})
public class InvoiceEntity extends GenericEntity implements Serializable {
    public static final String FIND_ALL = "InvoiceEntity.findAll";

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private UserEntity staff;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UserEntity student;
}
