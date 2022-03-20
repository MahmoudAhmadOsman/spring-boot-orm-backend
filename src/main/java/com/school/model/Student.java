package com.school.model;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotEmpty(message = "First name is required!")
   @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required!")
    @Column(name = "last_name")
    private  String lastName;

    @NotEmpty(message = "Email is required!")
    @Column(name = "email_address", unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required!")
    @Column(name = "phone_number")
    private String phone;


    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "registered_at")
    private Date registeredAt;




}
