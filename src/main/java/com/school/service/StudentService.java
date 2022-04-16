package com.school.service;
import com.school.beans.Student;
import com.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    //Get student list
    public List<Student> getAllStudent(){
        try{
            return studentRepository.findAll();
        }
        catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No student list found!", e);
        }
    }

    //Create  a student record
    public  Student saveStudent(Student student){
        try{
            return studentRepository.save(student);
        }catch (Exception e){
            throw new ResponseStatusException(
             HttpStatus.BAD_REQUEST, "Unable to save this record!", e
            );
        }
    }


    //Get student record by id
    public Student findStudentById(Long id){
        try{
            return studentRepository.findById(id).get();
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Can't find student with this id!", e
            );
        }

    }

    //Delete student
    public void deleteStudent(Long id){
        try{
            studentRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "Unable to delete this record!", e
            );
        }

    }

}
