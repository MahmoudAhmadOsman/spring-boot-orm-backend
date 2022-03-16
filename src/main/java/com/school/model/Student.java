package com.school.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
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

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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
}
