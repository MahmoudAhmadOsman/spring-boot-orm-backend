package com.school.service;
import com.school.beans.Teacher;
import com.school.repository.TeacherRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRespository teacherRespository;

    //Get method
    public List<Teacher> getListOfTeacher(){
        return teacherRespository.findAll();
    }

    //Post method
    public Teacher saveTeacher(Teacher teacher){
            return teacherRespository.save(teacher);
    }

    //Find by id method
    public Teacher findTeacherById(Long teacherId){
        return teacherRespository.findById(teacherId).get();
    }

    //Delete method
    public void deleteTeacher(Long teacherId){
         teacherRespository.deleteById(teacherId);
    }




}


