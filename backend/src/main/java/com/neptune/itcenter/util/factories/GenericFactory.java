package com.neptune.itcenter.util.factories;

import com.github.javafaker.Faker;
import com.neptune.itcenter.entities.GenericEntity;

import java.util.List;

public abstract class GenericFactory<E extends GenericEntity> {
    protected Faker faker;

    public GenericFactory() {
        faker = new Faker();
    }

    public abstract List<E> createEntities(int amount);
}
