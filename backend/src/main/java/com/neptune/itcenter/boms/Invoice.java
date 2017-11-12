package com.neptune.itcenter.boms;

public class Invoice extends Bom {
    private User staff;

    private User student;

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
