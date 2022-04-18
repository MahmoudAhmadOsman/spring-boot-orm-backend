package com.school.service;
import com.school.beans.Teacher;
import com.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    //Get method
    public List<Teacher> getListOfTeacher(){

        return teacherRepository.findAll();
    }

    //Post method
    public Teacher saveTeacher(Teacher teacher){
            return teacherRepository.save(teacher);
    }

    //Find by id method
    public Teacher findTeacherById(Long teacherId){
        return teacherRepository.findById(teacherId).get();
    }

    //Delete method
    public void deleteTeacher(Long teacherId){
         teacherRepository.deleteById(teacherId);
    }




}


