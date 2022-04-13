package com.school.beans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @NotNull
    private  Long courseId;

    private String courseName;
    @Max(5)
    @PositiveOrZero
    private int courseCredit;

    private int courseCost;
//    private BigDecimal courseCost;

    @Lob
    private String description;

    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;



// One-to-one: - bidirectional mapping
// Column is already defined in CourseMaterial attribute
    @OneToOne(
         mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


    //Teacher orm
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;





}
