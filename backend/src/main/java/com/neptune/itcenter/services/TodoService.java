package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Todo;
import com.neptune.itcenter.entities.TodoEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TodoService extends GenericService<TodoEntity, Todo> {

    public TodoService() {
        super(TodoEntity.class);
    }

    public List<TodoEntity> findAll() {
        TypedQuery<TodoEntity> query = getEntityManager().createNamedQuery(TodoEntity.FIND_ALL, TodoEntity.class);
        return query.getResultList();
    }

    public TodoEntity add(Todo todo) {
        return super.add(toEntity(todo));
    }

    public TodoEntity update(Todo todo) {
        TodoEntity entity = findById(todo.getId());
        entity.setContent(todo.getContent());
        entity.setCompleted(todo.isCompleted());
        return super.update(entity);
    }

    @Override
    public TodoEntity toEntity(Todo bom) {
        if (bom == null)
            return null;
        TodoEntity entity = new TodoEntity();
        entity.setId(bom.getId());
        entity.setContent(bom.getContent());
        entity.setCompleted(bom.isCompleted());
        entity.setCreatedAt(bom.getCreatedAt());
        entity.setUpdatedAt(bom.getUpdatedAt());
        return entity;
    }

    @Override
    public Todo toBom(TodoEntity entity) {
        if (entity == null)
            return null;
        Todo bom = new Todo();
        bom.setId(entity.getId());
        bom.setContent(entity.getContent());
        bom.setCompleted(entity.isCompleted());
        bom.setCreatedAt(entity.getCreatedAt());
        bom.setUpdatedAt(entity.getUpdatedAt());
        return bom;
    }

}

