package com.school.controller;
import com.school.model.Student;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class StudentController {
    @Autowired
   private StudentService  studentService;

    //Get all Student
    @GetMapping(value = "/students")
        public ResponseEntity<List<Student>> StudentList(){
                List<Student> students = studentService.getAllStudent();
               return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

            }


    //Add/post new student
    @PostMapping(value = "/students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent = studentService.createStudent(student);
        return new ResponseEntity<Student>(createStudent, HttpStatus.CREATED);
    }





}
