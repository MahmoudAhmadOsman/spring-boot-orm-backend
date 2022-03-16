package com.school.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotEmpty(message = "Frist name is required!")
   @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required!")
    @Column(name = "last_name")
    private  String lastName;

    @NotEmpty(message = "Email is required!")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Phone number is required!")
    @Column(name = "phone")
    private String phone;


    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "registered_at")
    private Date registeredAt;



    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phone, Date registeredAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.registeredAt = registeredAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }
}
