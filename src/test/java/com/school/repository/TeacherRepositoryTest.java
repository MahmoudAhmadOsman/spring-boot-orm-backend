package com.school.repository;

import com.school.beans.Course;
import com.school.beans.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    //1st create course that this teacher will be teaching
    public void saveTeacher(){
        Course php = Course.builder()
                .courseName("PHP")
                .courseCredit(4)
                .courseCost(1800)
                .description("This course teach PHP fundamentals")
                .build();

        Course cpp = Course.builder()
                .courseName("C++")
                .courseCredit(6)
                .courseCost(2800)
                .description("Teaches C++ fundamentals")
                .build();

        Teacher teacher =
                Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                .emailAddress("john_smith@yahoo.com")
                .courses(List.of(php, cpp))
                .build();
        teacherRepository.save(teacher);


    }


}