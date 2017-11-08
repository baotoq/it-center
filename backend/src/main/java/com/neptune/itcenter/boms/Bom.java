package com.neptune.itcenter.boms;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Bom implements Serializable {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deleteAt;

    public Bom() {
    }

    public Bom(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deleteAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deleteAt = deleteAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(LocalDateTime deleteAt) {
        this.deleteAt = deleteAt;
    }
}
