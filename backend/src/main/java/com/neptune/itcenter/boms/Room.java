package com.neptune.itcenter.boms;

import java.util.List;

public class Room extends Bom {
    private boolean active;
    private List<Class> classes;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
