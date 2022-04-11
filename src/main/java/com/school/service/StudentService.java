package com.school.service;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    //Get student list
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }


    //Create  a student record
    public  Student saveStudent(Student student){
        return studentRepository.save(student);
    }


    //Get student record by id
    public Student findStudentById(Long id){
        return studentRepository.findById(id).get();
    }

    //Delete student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
