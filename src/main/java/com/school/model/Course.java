package com.school.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity

@Table(name = "courses")
@Data
public class Course {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Course name is required!")

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

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;


    //m:m orm
    //course is the owning side - OneToOne rom
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "student_id")
    private List<Student> student;



}
