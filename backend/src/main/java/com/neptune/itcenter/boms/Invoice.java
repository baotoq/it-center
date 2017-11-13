package com.neptune.itcenter.boms;

public class Invoice extends Bom {
    private User student;
    private User staff;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }
}
