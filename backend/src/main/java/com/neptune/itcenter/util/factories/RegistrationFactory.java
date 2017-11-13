package com.neptune.itcenter.util.factories;

import com.neptune.itcenter.entities.ClassEntity;
import com.neptune.itcenter.entities.InvoiceEntity;
import com.neptune.itcenter.entities.RegistrationEntity;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFactory extends GenericFactory<RegistrationEntity> {
    private List<ClassEntity> classes;
    private List<InvoiceEntity> invoices;

    public RegistrationFactory(int amount, List<ClassEntity> classes, List<InvoiceEntity> invoices) {
        super(amount);
        this.classes = classes;
        this.invoices = invoices;
    }

    @Override
    public List<RegistrationEntity> createEntities() {
        List<RegistrationEntity> registrationEntities = new ArrayList<>();

        for (int i = 0; i < getAmount(); i++) {
            RegistrationEntity entity = new RegistrationEntity();
            entity.setAttendedClass(classes.get(faker.random().nextInt(classes.size())));
            entity.setInvoice(invoices.get(faker.random().nextInt(invoices.size())));
            registrationEntities.add(entity);
        }

        return registrationEntities;
    }
}
