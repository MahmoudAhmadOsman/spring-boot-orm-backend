package com.school.model;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "students")
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

//    @NotEmpty(message = "First name is required!")
   @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private  String lastName;


    @Column(name = "email_address", unique = true)
    private String email;


    @Column(name = "phone_number")
    private String phone;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    //1:m orm
    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_course_fk", referencedColumnName = "id")
    private Set<Course> courses;



}
