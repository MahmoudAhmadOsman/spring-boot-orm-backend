package com.school.service;

import com.school.model.Course;

import java.util.List;

public interface CourseServices {

    //Get method
     List<Course> getAllCourses();

    //Post/create method
     Course save(Course course);


     //findById method
    Course findById(Long id);

    //Update method
    Course update(Long id);

    //Delete method
    void delete(Long id);


}
