## Spring Boot ORM

I This project is demo of Spring boot ORM.
## Code Snippet

 ##### Course POJO class

```bash
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
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Course credit is required!")
    @Column(name = "credit")
    private Number credit;

    @Temporal(value = TemporalType.TIMESTAMP)
@Column(name = "created_time")
    private Date createdAt;

    @NotEmpty(message = "Course description is required!")
    @Lob
    @Column(name = "description")
    private Long description;


    //1:m orm

//

    //course is the owning side - OneToOne rom
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
private List<Student> student;

    public Course() {
    }

    public Course(String name, Number credit, Date createdAt, Long description) {
        this.name = name;
        this.credit = credit;
        this.createdAt = createdAt;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCredit() {
        return credit;
    }

    public void setCredit(Number credit) {
        this.credit = credit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }
}


```





## Contributing

Please, feel free to contrubute to this and correct me if you see anything wrong about this project or if you have any sugguestions that would also welcomed.

### My Website

Please, visit my website
[mahmoudosman.com](http://www.mahmoudosman.com/)


### Social Media

LinkedIn Profile Link: [LinkedIn](https://www.linkedin.com/in/mahmoudaoman/) 
