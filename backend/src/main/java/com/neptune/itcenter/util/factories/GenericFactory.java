package com.neptune.itcenter.util.factories;

import com.github.javafaker.Faker;
import com.neptune.itcenter.entities.GenericEntity;

import java.util.List;

public abstract class GenericFactory<E extends GenericEntity> {
    protected Faker faker;
    private int amount;

    public GenericFactory(int amount) {
        faker = new Faker();
        this.amount = amount;
    }

    public abstract List<E> createEntities();

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
