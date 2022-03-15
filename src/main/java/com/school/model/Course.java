package com.school.model;

import javax.persistence.*;

@Entity (name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "credit", nullable = false)
    private Number credit;

    @Lob
    @Column(name = "description")
    private Long description;



    public Course() {
    }

    public Course(String name, Number credit, Long description) {
        this.name = name;
        this.credit = credit;
        this.description = description;
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

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }
}
