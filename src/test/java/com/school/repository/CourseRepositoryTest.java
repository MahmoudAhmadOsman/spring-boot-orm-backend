package com.school.repository;
import com.school.beans.Course;
import com.school.beans.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    //1st, set the orm in the course entity
    //Save teacher with course
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Mahmoud")
                .lastName("Osman")
                .emailAddress("mahmoud_145@um.edu")
                .build();

        Course course = Course.builder()
                .courseName("WordPress")
                .courseCost(654)
                .courseCredit(3)
                .description("Teaches WordPress basics")
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }


}