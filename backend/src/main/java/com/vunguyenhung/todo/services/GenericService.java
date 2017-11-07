package com.vunguyenhung.todo.services;

/**
 * Created by vunguyenhung on 7/14/17.
 */

import com.vunguyenhung.todo.entities.GenericEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericService<E extends GenericEntity, B> {

    private static final Logger logger = LoggerFactory.getLogger(GenericService.class);

    private final Class<E> entityClass;

    @PersistenceContext(name = "todoPU")
    EntityManager em;

    public GenericService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract E toEntity(B bom);

    public abstract B toBom(E entity);

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public E save(E entity) {
        if (entity.getId() != null) {
            this.em.merge(entity);
        } else {
            this.em.persist(entity);
        }
        this.em.flush();
        return entity;
    }

    public void delete(E entity) {
        this.em.remove(entity);
    }

    public E findById(Integer id) {
        return em.find(entityClass, id);
    }

    public void removeById(Integer id) {
        em.remove(findById(id));
    }


    public List<E> toEntities(List<B> boms) {
        if (boms == null) {
            return null;
        }
        List<E> entities = new ArrayList<>();
        //Under testing
        for (B b : boms) {
            E entity = toEntity(b);
            if (entity != null)
                entities.add(entity);
        }

        return entities;
    }

    public List<B> toBoms(List<E> entities) {
        if (entities == null) {
            return null;
        }
        List<B> boms = new ArrayList<>();
        //Under testing
        for (E e : entities) {
            B bom = toBom(e);
            if (bom != null)
                boms.add(bom);
        }

        return boms;
    }
}
