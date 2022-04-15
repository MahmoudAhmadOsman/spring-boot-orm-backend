package com.school.service;

import com.school.beans.Course;
import com.school.config.BusinessException;
import com.school.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplementation implements CourseServicesInterface {

    @Autowired
    private  CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        if(course.getCourseName().isEmpty() || course.getCourseName().length() == 0){
            throw new BusinessException("601","Course name is required!");
        }
        try{
            Course saveCourse = courseRepository.save(course);
            return saveCourse;
        }catch (IllegalArgumentException e){
            throw new BusinessException("602","Course is empty" + e.getMessage());
        }catch (Exception e){
            throw new BusinessException("603","Unable to save course info" + e.getMessage());
        }


    }


    @Override
    public List<Course> getAllCourses() {
        List<Course> courseList = null;
        try {
          courseList = courseRepository.findAll();
        }catch (Exception e){
            throw new BusinessException("604","Something went wrong in service layer" + e.getMessage());
        }
        if (courseList.isEmpty()){
            throw new BusinessException("605", "Course list is empty");
        }
            return courseList;

    }

    @Override
    public Course findById(Long id) {
      try{
          return courseRepository.findById(id).get();

      }catch (IllegalArgumentException e) {
          throw new BusinessException("608","Course id is required" + e.getMessage());
      }
      catch (java.util.NoSuchElementException e) {
          throw new BusinessException("609","Cannot find course with this id" + e.getMessage());
      }catch (Exception e) {
          throw new BusinessException("610","Something went wrong in service layer " + e.getMessage());
      }
    }


    //  public Course findById(Long id) {
    //        if(courseRepository.findById(id).isPresent()){
    //            return courseRepository.findById(id).get();
    //        }
    //        return null;
    //    }

    @Override
    public Course update(Long id) {
       if(courseRepository.findById(id).isPresent()){
           return courseRepository.findById(id).get();
       }else {
           return null;
       }
    }


    @Override
    public void  delete(Long id) {

        try {
            Course course = findById(id);
            courseRepository.delete(course);
        }catch (IllegalArgumentException e) {
            throw new BusinessException("606", "Unable to delete course" + e.getMessage());
        }catch (Exception e){
            throw  new BusinessException("607", "Something went wrong in service later" + e.getMessage());
        }


    }


}
