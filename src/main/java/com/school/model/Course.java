package com.school.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
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

    @Temporal(value = TemporalType.TIMESTAMP)
@Column(name = "created_time")
    private Date createdAt;

    @NotEmpty(message = "Course description is required!")
    @Lob
    @Column(name = "description")
    private Long description;


    //1:m orm

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private Set<Student> students;
//private  Student student;

    public Course() {
    }

    public Course(String name, Number credit, Date createdAt, Long description) {
        this.name = name;
        this.credit = credit;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }
}
