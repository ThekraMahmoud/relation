package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.DTO.TeacherDTO;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;



    public List<Course>get(){
        return courseRepository.findAll();
    }



    public void update(Integer id ,Course course){

       Course course1= courseRepository.findCourseById(id);
       if(course1==null){
           throw new ApiException("id not found ");
       }
       course1.setName(course.getName());
       courseRepository.save(course1);
    }



    public void delete(Integer id){
        Course course1= courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiException("id not found ");
        }
        courseRepository.delete(course1);
    }


    public void add(Integer teacher_id, Course course){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);

        if(teacher==null){
            throw new ApiException(" teacher id not found ");
        }
        course.setTeacher1(teacher);
        courseRepository.save(course);
    }

    public TeacherDTO getTeacherByCourseId(Integer course_id){
        Course course=courseRepository.findCourseById(course_id);

        if(course==null){
            throw new ApiException("course id not found ");
        }
        if(course.getTeacher1()==null){
            throw new ApiException("teacher not found ");

        }
        TeacherDTO teacherDTO=new TeacherDTO();
        teacherDTO.setName(course.getTeacher1().getName());

        return teacherDTO;
    }

}
