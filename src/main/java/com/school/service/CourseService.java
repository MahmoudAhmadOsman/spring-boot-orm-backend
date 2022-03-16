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

    //Get method - get list of courses
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    //Post method - create new course
    public List<Course> postCourse(List<Course> course){
        return courseRepository.saveAll(course);

    }

    //Save method - save a course
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    //Get by id - get course by its id
    public Course getCourseById(Course course){
        Course existingCourse = courseRepository.findById(course.getId()).orElse(null);
        existingCourse.setName(course.getName());
        existingCourse.setCredit(course.getCredit());
        existingCourse.setCreatedAt(course.getCreatedAt());
        existingCourse.setDescription(course.getDescription());
        return courseRepository.save(existingCourse);
    }


//Delete method - Delete a course

    public String deleteCourse(Long id){
        courseRepository.deleteById(id);
        return "Course has been deleted successfully: " + id;
    }


}
