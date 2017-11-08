package com.neptune.itcenter.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
@NamedQueries({
        @NamedQuery(name = InvoiceEntity.FIND_ALL, query = "SELECT t FROM InvoiceEntity t"),
})
public class InvoiceEntity extends GenericEntity {
    public static final String FIND_ALL = "InvoiceEntity.findAll";
}
