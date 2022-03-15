package com.school.model;

public class Course {
    private Long id;
    private String name;
    private Number credit;


    public Course() {
    }


    public Course(String name, Number credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCredit() {
        return credit;
    }

    public void setCredit(Number credit) {
        this.credit = credit;
    }
}
