package com.school.repository;


import com.school.beans.Guardian;
import com.school.beans.Student;
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
    Guardian guardian = Guardian.builder()
            .guardianName("Mahmoud")
            .guardianEmail("mahmoud@yahoo.com")
            .guardianPhone("8026987451")
            .build();

    Student s1 = Student.builder()
            .firstName("John")
            .lastName("Doe")
            .emailAddress("jdoe@gmail.com")
            .phoneNumber("8064526853")
            .guardian(guardian)

            .build();

    Student s2 = Student.builder()
            .firstName("Smith")
            .lastName("Doe")
            .emailAddress("sjoe@yahoo.com")
            .phoneNumber("6124879541")
            .guardian(guardian)

            .build();

    studentRepository.save(s1);
    studentRepository.save(s2) ;

    }

@Test
    public  void getAllStudent(){
    List<Student> studentList =
            studentRepository.findAll();
   System.out.println("Student list: " + studentList);

    }


}