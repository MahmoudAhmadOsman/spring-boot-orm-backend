package com.school.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "students")
public class Student {
@Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private  Long id;

    private String firstName;
    private  String lastName;
    @Column(unique = true)
    private String emailAddress;
    private String phoneNumber;


    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;


//Embed the guardian class here
    @Embedded
    private Guardian guardian;


    //1:m orm
//    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_course_fk", referencedColumnName = "id")
//    private Set<Course> course;



}
