package com.neptune.itcenter.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "todos")
@NamedQueries({
        @NamedQuery(name = TodoEntity.FIND_ALL, query = "SELECT t FROM TodoEntity t"),
})
public class TodoEntity extends GenericEntity implements Serializable {

    public static final String FIND_ALL = "TodoEntity.findAll";

    @Column(name = "content", length = 50, nullable = false)
    private String content;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.createdAt = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TodoEntity that = (TodoEntity) o;
        return completed == that.completed &&
                Objects.equals(content, that.content) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content, completed, createdAt);
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id='" + getId() + '\'' +
                ", content='" + content +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


}
