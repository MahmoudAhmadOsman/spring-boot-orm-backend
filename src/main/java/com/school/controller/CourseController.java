package com.school.controller;
import com.school.model.Course;
import com.school.service.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1") //Annotation the @RequestMapping on the class level
public class CourseController {
    @Autowired
    private CourseServices courseService;


    //Get list of courses
      @GetMapping("/courses")
        public ResponseEntity<List<Course>> coursesList(){
            List<Course> courses = courseService.getAllCourses();
           return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);

        }


    //Create/post new course
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course course1 = courseService.createCourse(course);
        return new ResponseEntity<Course>(course1, HttpStatus.OK);
    }




}
