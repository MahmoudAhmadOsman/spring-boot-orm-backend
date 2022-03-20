package com.school.service;

import com.school.model.Course;

import java.util.List;

public interface CourseServices {

    //Get method
     List<Course> getCourses();

    //Post/create method
     Course createCourse(Course course);


}
