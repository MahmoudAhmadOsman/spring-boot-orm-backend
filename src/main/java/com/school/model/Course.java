package com.school.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Course name is required!")
    @Size(max = 100)
    @Column(name = "course_name")
    private String name;

    @NotEmpty(message = "Course credit is required!")
    @Column(name = "course_credit")
    private int credit;

     @NotEmpty(message = "Course cost is required!")
     @Column(name = "course_cost")
    private BigDecimal cost;

    @NotEmpty(message = "Course description is required!")
    @Lob
    @Column(name = "description")
    private String description;


    //m:m orm
    //course is the owning side - OneToOne rom
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Student> student;

    public Course() {
    }

    public Course(String name, int credit, BigDecimal cost, String description) {
        this.name = name;
        this.credit = credit;
        this.cost = cost;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
