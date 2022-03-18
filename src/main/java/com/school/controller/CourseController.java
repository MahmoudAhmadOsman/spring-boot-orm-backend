package com.school.controller;
import com.school.model.Course;
import com.school.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api/v1/")
public class CourseController {
    @Autowired
    private CourseService courseService;


    //Home page route
    @GetMapping("/")
    public String home(){
        return "Welcome to home page";
    }


    //Get list of courses
    @RequestMapping("/courses")
    public String coursesList(){
        List<Course> listCourses = courseService.getCourses();
        return "Courses List page!";

    }

    //Save course
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
        return  courseService.saveCourse(course);


    }









}
