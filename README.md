## Spring Boot ORM

I This project is demo of Spring boot ORM.
## Code Snippet

 ##### Course POJO class

```bash
 package com.school.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
 package com.school.model;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Course name is required!")
    @Column(name = "course_name")
    private String name;

    @NotEmpty(message = "Course credit is required!")
    @Column(name = "course_credit")
    private Number credit;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @NotEmpty(message = "Course description is required!")
    @Lob
    @Column(name = "description")
    private Long description;


}


```





## Contributing

Please, feel free to contrubute to this and correct me if you see anything wrong about this project or if you have any sugguestions that would also welcomed.

### My Website

Please, visit my website
[mahmoudosman.com](http://www.mahmoudosman.com/)


### Social Media

LinkedIn Profile Link: [LinkedIn](https://www.linkedin.com/in/mahmoudaoman/) 
