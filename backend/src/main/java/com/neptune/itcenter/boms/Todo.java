package com.neptune.itcenter.boms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Todo extends Bom {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 50)
    private String content;

    @NotNull
    private boolean completed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        Todo todo = (Todo) o;
        return completed == todo.completed &&
                Objects.equals(id, todo.id) &&
                Objects.equals(content, todo.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, completed);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", completed=" + completed +
                '}';
    }

}
