package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todos")
@NamedQueries({
        @NamedQuery(name = TodoEntity.FIND_ALL, query = "SELECT t FROM TodoEntity t"),
})
public class TodoEntity extends GenericEntity {

    public static final String FIND_ALL = "TodoEntity.findAll";

    @Column(length = 50, nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean completed;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TodoEntity that = (TodoEntity) o;
        return completed == that.completed &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content, completed);
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id='" + getId() + '\'' +
                ", content='" + content +
                ", completed=" + completed +
                '}';
    }


}
