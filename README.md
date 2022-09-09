## Spring Boot ORM

I This project is demo of Spring boot ORM.
## Code Snippet

 ##### Course POJO class

```bash


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator( name = "course_sequence", sequenceName = "course_sequence",  allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private  Long courseId;

    private String courseName;
    @Max(5)
    @PositiveOrZero
    private int courseCredit;

    private BigDecimal courseCost;

    @Lob
    private String description;

    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;
}


```


### My Website

Please, visit my website
[mahmoudosman.com](http://www.mahmoudosman.com/)


### Social Media

LinkedIn Profile Link: [LinkedIn](https://www.linkedin.com/in/mahmoudaoman/) 
