package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Bom;
import com.neptune.itcenter.entities.GenericEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericService<E extends GenericEntity, B extends Bom> {

    private final Class<E> entityClass;

    @PersistenceContext(name = "itcenterPU")
    private EntityManager entityManager;

    public GenericService(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public E findById(Integer id) {
        return entityManager.find(entityClass, id);
    }

    public E add(E entity) {
        this.entityManager.persist(entity);
        this.entityManager.flush();
        return entity;
    }

    public E add(B bom) {
        return add(toEntity(bom));
    }

    public void add(List<E> entities) {
        for (E entity : entities) {
            add(entity);
        }
    }

    public E update(E entity) {
        if (entity.getId() == null) {
            //throw new Exception();
        }
        this.entityManager.merge(entity);
        this.entityManager.flush();
        return entity;
    }

    public void delete(E entity) {
        entity.setDeleteAt(LocalDateTime.now());
        update(entity);
        //this.entityManager.remove(entity);
    }

    public void delete(List<E> entities) {
        for (E entity : entities) {
            delete(entity);
        }
    }

    public abstract E toEntity(B bom);

    public abstract B toBom(E entity);

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
