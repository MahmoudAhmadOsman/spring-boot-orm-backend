package com.school.controller;
import com.school.beans.Course;
import com.school.service.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1") //Annotation the @RequestMapping on the class level
public class CourseController {
    @Autowired
    private CourseServices courseService;


    //Get list of courses
      @GetMapping(value = "/courses")
        public ResponseEntity<List<Course>> coursesList(){
            List<Course> courses = courseService.getAllCourses();
           return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);

        }


    //Create/post new course
    @PostMapping(value = "/courses")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course course1 = courseService.save(course);
        return new ResponseEntity<Course>(course1, HttpStatus.CREATED);
    }


    //findById method
    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course> findByIdCourse(@PathVariable("id") Long id){
          Course course = courseService.findById(id);
          return new ResponseEntity<Course>(course, HttpStatus.OK);
    }


    //Update method

    @PutMapping(value = "/courses/{id}/edit")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseService.update(id);
        return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
    }


//    @PutMapping("/courses/{id}/edit")
//    public void updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
//        Course updatedCourse =  courseService.updateCourse(course);
//    }


    //Delete method
    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id){
          courseService.delete(id);
          return new ResponseEntity<>("Course has been deleted successfully", HttpStatus.ACCEPTED);
}


}
