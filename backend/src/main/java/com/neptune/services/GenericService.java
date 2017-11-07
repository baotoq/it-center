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

    @PersistenceContext
    EntityManager entityManager;

    public GenericService() {
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    public void create(E entity) {
        entityManager.persist(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }
}
