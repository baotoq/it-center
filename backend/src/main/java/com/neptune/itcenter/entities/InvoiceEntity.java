package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoices")
@NamedQueries({
        @NamedQuery(name = InvoiceEntity.FIND_ALL, query = "SELECT t FROM InvoiceEntity t"),
})
public class InvoiceEntity extends GenericEntity implements Serializable {
    public static final String FIND_ALL = "InvoiceEntity.findAll";

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private UserEntity student;

    @Column
    private boolean confirmed;

    @Column
    private Integer total;

    public UserEntity getStudent() {
        return student;
    }

    public void setStudent(UserEntity student) {
        this.student = student;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
