package com.neptune.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Article extends GenericEntity {

    @Column
    private String title;
    @Column
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
