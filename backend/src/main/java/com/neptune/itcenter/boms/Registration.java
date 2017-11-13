package com.neptune.itcenter.boms;

public class Registration extends Bom {
    private Class attendedClass;
    private Invoice invoice;
    private User student;
    private int absent;
    private int late;
    private int grade;

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public Class getAttendedClass() {
        return attendedClass;
    }

    public void setAttendedClass(Class attendedClass) {
        this.attendedClass = attendedClass;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}
