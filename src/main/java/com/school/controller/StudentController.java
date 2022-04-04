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

        /*
           //findById method
            @GetMapping(value = "/courses/{id}")
            public ResponseEntity<Course> findByIdCourse(@PathVariable("id") Long id){
                  Course course = courseService.findById(id);
                  return new ResponseEntity<Course>(course, HttpStatus.OK);
            }

        * */



    //findById method
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }




    //Add/post new student
    @PostMapping(value = "/students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent = studentService.saveStudent(student);
        return new ResponseEntity<Student>(createStudent, HttpStatus.CREATED);
    }



    //@UPDATE METHOD
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentService.findStudentById(id);
        Student updatedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(updatedStudent);

    }


    //Delete student
    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student has been deleted successfully", HttpStatus.OK);

    }




}
