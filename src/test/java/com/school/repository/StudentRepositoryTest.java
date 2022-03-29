package com.school.repository;


import com.school.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
private StudentRepository studentRepository;

@Test
public  void saveStudent(){
    Student student = Student.builder()
            .firstName("Mahmoud")
            .lastName("Osman")
            .emailAddress("mahmoud@gmail.com")
            .phoneNumber("6515554444")
            .build();

    studentRepository.save(student) ;

    }

@Test
    public  void getAllStudent(){
    List<Student> studentList =
            studentRepository.findAll();
   System.out.println("Student list: " + studentList);

    }


}