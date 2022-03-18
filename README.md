## Spring Boot ORM

I This project is demo of Spring boot ORM.
## Code Snippet

 ##### Course POJO class

```bash
 package com.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required!")
    @Column(name = "phone")
    private String phone;


    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "registered_at")
    private Date registeredAt;




}


```





## Contributing

Please, feel free to contrubute to this and correct me if you see anything wrong about this project or if you have any sugguestions that would also welcomed.

### My Website

Please, visit my website
[mahmoudosman.com](http://www.mahmoudosman.com/)


### Social Media

LinkedIn Profile Link: [LinkedIn](https://www.linkedin.com/in/mahmoudaoman/) 
