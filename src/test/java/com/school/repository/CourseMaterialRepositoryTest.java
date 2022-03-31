package com.school.repository;
import com.school.model.Course;
import com.school.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void saveCourseMaterial(){
        Course course =
                Course.builder()
                        .courseName("Java")
                        .courseCredit(4)
                        .courseCost(2500)
                        .description("This course teaches Java basics")
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .courseBook("Mastering Java & Spring ")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }



    //Get list of course material
    @Test
    public  void getListOfCourseMaterial(){
        List<CourseMaterial> courseMaterial =
                courseMaterialRepository.findAll();
        System.out.println("Course Material list: " + courseMaterial);

    }




}