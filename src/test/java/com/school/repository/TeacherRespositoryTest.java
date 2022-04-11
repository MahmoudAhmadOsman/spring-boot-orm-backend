package com.school.repository;

import com.school.model.Course;
import com.school.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRespositoryTest {

    @Autowired
    private TeacherRespository teacherRespository;


    @Test
    public void saveTeacher(){
    //1st create course that this teacher will be teaching
        Course java = Course.builder()
                .courseName("PHP")
                .courseCredit(4)
                .courseCost(2800)
                .description("This course teach PHP fundamentals")
                .build();
        Course cpp = Course.builder()
                .courseName("C++")
                .courseCredit(4)
                .courseCost(2800)
                .description("Teaches C++ fundamentals")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mahmoud")
                .lastName("Osman")
                .courses(List.of(java, cpp))
                .build();

        teacherRespository.save(teacher);

    }


}