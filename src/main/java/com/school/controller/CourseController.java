package com.school.controller;
import com.school.beans.Course;
import com.school.config.BusinessException;
import com.school.config.ControllerException;
import com.school.service.CourseServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1") // class level annotation
public class CourseController {
    @Autowired
    private CourseServicesInterface courseService;


    //Get list of courses
      @GetMapping(value = "/courses")
        public ResponseEntity<List<Course>> coursesList(){
              List<Course> courses = courseService.getAllCourses();
              return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
        }


    //Create/post new course
    @PostMapping(value = "/courses/create")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
       try{
           Course saveCourse = courseService.save(course);
           return new ResponseEntity<Course>(saveCourse, HttpStatus.CREATED);
       }catch (BusinessException e){
           ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
        return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

       }catch (Exception e){
        ControllerException ce = new ControllerException("611", "Something went wrong in controller!");
        return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
       }

    }


    //get by id method
    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<?> findByIdCourse(@PathVariable("id") Long id){
          try{
              Course course = courseService.findById(id);
              return new ResponseEntity<Course>(course, HttpStatus.OK);
          }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("612", "Something went wrong in controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }
    }


    //Update method

    @PutMapping(value = "/courses/{id}/edit")
    public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {

          try {
              Course updatedCourse = courseService.update(id);
              return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
          }catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("613", "Something went wrong in controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

    }


//    @PutMapping("/courses/{id}/edit")
//    public void updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
//        Course updatedCourse =  courseService.updateCourse(course);
//    }


    //Delete method
    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id){
          try{
              courseService.delete(id);
              return new ResponseEntity<>("Course has been deleted successfully", HttpStatus.ACCEPTED);
          } catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            ControllerException ce = new ControllerException("614", "Something went wrong in controller!");
            return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
        }

}


}
