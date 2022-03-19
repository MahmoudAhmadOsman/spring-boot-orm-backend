package com.school.service;

import com.school.model.Course;
import com.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //Get list of courses
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    //Post method - create new course
    public List<Course> postCourse(List<Course> course){
        return courseRepository.saveAll(course);

    }

    //Save method
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    //Get by id
    public Course getCourseById(Course course){
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        existingCourse.setName(course.getName());
        existingCourse.setCredit((Integer) course.getCredit());
        existingCourse.setCreatedAt(course.getCreatedAt());
        existingCourse.setDescription(course.getDescription());
        return courseRepository.save(existingCourse);
    }

    //Delete method
    public String deleteCourse(Long id){
        courseRepository.deleteById(id);
        return "Course has been deleted successfully: " + id;
    }


}
