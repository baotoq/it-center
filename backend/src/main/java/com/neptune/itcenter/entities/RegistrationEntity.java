package com.neptune.itcenter.entities;

import javax.persistence.*;

@Entity
@Table(name = "registration")
@NamedQueries({
        @NamedQuery(name = RegistrationEntity.FIND_ALL_BY_USERNAME, query = "SELECT r FROM RegistrationEntity r WHERE r.student.username = :username"),
        @NamedQuery(name = RegistrationEntity.FIND_ALL, query = "SELECT r FROM RegistrationEntity r"),
})
public class RegistrationEntity extends GenericEntity {

    public static final String FIND_ALL_BY_USERNAME = "RegistrationEntity.findAllByUsername";
    public static final String FIND_ALL = "RegistrationEntity.findAll";

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity attendedClass;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private UserEntity student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private InvoiceEntity invoice;

    @Column(name = "grade")
    private int grade;

    @Column
    private int absent;

    @Column
    private int late;
}
