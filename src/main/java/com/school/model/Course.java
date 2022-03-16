package com.school.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Course {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Course name is required!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Course credit is required!")
    @Column(name = "credit")
    private Number credit;

    @NotEmpty(message = "Course description is required!")
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
