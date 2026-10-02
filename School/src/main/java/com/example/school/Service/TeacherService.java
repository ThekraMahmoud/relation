package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;



    public List<Teacher>get(){
        return teacherRepository.findAll();
    }


    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Integer id ,Teacher teacher){
        Teacher t=teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException(" Teacher id not found");
        }
        t.setName(teacher.getName());
        t.setAddress(teacher.getAddress());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }


    public void delete(Integer id){
        Teacher t=teacherRepository.findTeacherById(id);
        if(t==null){
            throw new ApiException(" Teacher id not found");
        }
        teacherRepository.delete(t);
    }


    public Teacher details(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException(" Teacher id not found");
        }
        return teacher;

    }


//    public Teacher getTeacherById(Integer teacherId){
//        Teacher teacher=teacherRepository.findTeacherById(teacherId);
//        if(teacher==null){
//            throw new ApiException("Teacher not found");
//        }
//        return teacher;
//    }




}
