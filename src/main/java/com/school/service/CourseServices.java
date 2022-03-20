package com.school.service;

import com.school.model.Course;

import java.util.List;

public interface CourseServices {

    //Get method
     List<Course> getAllCourses();

    //Post/create method
     Course createCourse(Course course);


     //Find by id
    Course findById(Long id);

    //Delete course
    void delete(Long id);


}
