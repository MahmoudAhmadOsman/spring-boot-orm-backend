package com.school.service;

import com.school.model.Course;
import com.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImplementation implements CourseServices {

        @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
         return courseRepository.save(course);

    }



}
