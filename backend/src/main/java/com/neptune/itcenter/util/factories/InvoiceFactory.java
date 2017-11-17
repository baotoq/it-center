package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.InvoiceEntity;
import com.neptune.itcenter.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFactory extends GenericFactory<InvoiceEntity> {
    private List<UserEntity> students;

    public InvoiceFactory(int amount, List<UserEntity> students) {
        super(amount);
        this.students = students;
    }

    @Override
    public List<InvoiceEntity> createEntities() {
        List<InvoiceEntity> invoiceEntities = new ArrayList<>();

        for (int i = 0; i < getAmount(); i++) {
            InvoiceEntity entity = new InvoiceEntity();
            entity.setTotal(faker.number().numberBetween(500000, 1000000));
            entity.setConfirmed(faker.bool().bool());
            entity.setStudent(students.get(faker.random().nextInt(students.size())));
            invoiceEntities.add(entity);
        }

        return invoiceEntities;
    }
}
