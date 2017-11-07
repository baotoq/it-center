package com.neptune.itcenter.services;

import com.neptune.itcenter.boms.Todo;
import com.neptune.itcenter.entities.TodoEntity;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class TodoService extends GenericService<TodoEntity, Todo> {

    public TodoService() {
        super(TodoEntity.class);
    }

    public List<TodoEntity> findAll() {
        TypedQuery<TodoEntity> query = getEm().createNamedQuery(TodoEntity.FIND_ALL, TodoEntity.class);
        return query.getResultList();
    }

    public TodoEntity save(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        TodoEntity toBeSavedTodo = toEntity(todo);
        return super.save(toBeSavedTodo);
    }

    public void update(Todo todo) {
        TodoEntity entity = findById(todo.getId());
        entity.setContent(todo.getContent());
        entity.setCompleted(todo.isCompleted());
        entity.setUpdatedAt(LocalDateTime.now());
        super.save(entity);
    }

    public void delete(Integer id) {
        TodoEntity entity = findById(id);
        super.delete(entity);
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

