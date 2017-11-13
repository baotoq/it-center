package com.neptune.itcenter.boms;

public class Invoice extends Bom {
    private User student;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
