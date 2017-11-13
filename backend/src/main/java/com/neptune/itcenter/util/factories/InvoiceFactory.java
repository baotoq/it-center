package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.InvoiceEntity;
import com.neptune.itcenter.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class InvoiceFactory extends GenericFactory<InvoiceEntity> {
    private List<UserEntity> students;

    private List<UserEntity> staffs;

    public InvoiceFactory(int amount, List<UserEntity> staffs, List<UserEntity> students) {
        super(amount);
        this.staffs = staffs;
        this.students = students;
    }

    @Override
    public List<InvoiceEntity> createEntities() {
        List<InvoiceEntity> invoiceEntities = new ArrayList<>();

        for (int i = 0; i < getAmount(); i++) {
            InvoiceEntity entity = new InvoiceEntity();
            entity.setStaff(staffs.get(faker.random().nextInt(staffs.size())));
            entity.setStudent(students.get(faker.random().nextInt(students.size())));
            invoiceEntities.add(entity);
        }

        return invoiceEntities;
    }
}
