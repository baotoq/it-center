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
    private final Class<B> bomClass;

    @PersistenceContext(name = "itcenterPU")
    private EntityManager entityManager;

    public GenericService(Class<E> entityClass, Class<B> bomClass) {
        this.entityClass = entityClass;
        this.bomClass = bomClass;
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
        entity.setDeletedAt(LocalDateTime.now());
        update(entity);
        //this.entityManager.remove(entity);
    }

    public void delete(List<E> entities) {
        for (E entity : entities) {
            delete(entity);
        }
    }

    private E createEntity() {
        try {
            return entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private B createBom() {
        try {
            return bomClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public B toBom(E entity) {
        if (entity == null)
            return null;
        B bom = createBom();
        bom.setId(entity.getId());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        bom.setDeletedAt(entity.getDeletedAt());
        return bom;
    }

    public E toEntity(B bom) {
        if (bom == null)
            return null;
        E entity = createEntity();
        entity.setId(bom.getId());
        return entity;
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
}
