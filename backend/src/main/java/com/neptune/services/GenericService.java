/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.services;

import com.neptune.entities.GenericEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Neptune
 * @param <E>
 */
public abstract class GenericService<E extends GenericEntity> {

    private final Class<E> entityClass;

    @PersistenceContext
    EntityManager entityManager;

    public GenericService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public E get(int id) {
        return entityManager.find(entityClass, id);
    }

    public void create(E entity) {
        entityManager.persist(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    public void remove(int id) {
        entityManager.remove(get(id));
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }
}
