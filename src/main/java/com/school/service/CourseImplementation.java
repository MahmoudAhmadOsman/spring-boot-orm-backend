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
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
         return courseRepository.save(course);

    }

    @Override
    public Course findById(Long id) {
        if(courseRepository.findById(id).isPresent()){
            return courseRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void  delete(Long id) {
        Course course = findById(id);
        courseRepository.delete(course);
    }


}
