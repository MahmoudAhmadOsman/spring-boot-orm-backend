package com.school.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity

@Table(name = "courses")
@Data
public class Course {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false, updatable = false)
    @Column(name = "course_id")
    private Long cid;


    @Column(name = "course_name")
    private String name;

    @Column(name = "course_credit")

    @Min(1)
    @Max(4)
    @PositiveOrZero
    private int credit;

    @Column(name = "course_cost")
    private BigDecimal cost;


    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;





}
