package com.example.school.Service;


import com.example.school.Api.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Student;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;



    public List<Student>get(){
        return studentRepository.findAll();
    }


    public void add(Student student){
        studentRepository.save(student);
    }


    public void update(Integer student_id ,Student student){
        Student student1=studentRepository.findStudentById(student_id);
        if(student1==null){
            throw new ApiException("Student id not found");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setCourse(student.getCourse());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }


    public void delete(Integer student_id){
        Student student=studentRepository.findStudentById(student_id);
        if(student==null){
            throw new ApiException("Student id not found");
        }
        studentRepository.delete(student);
    }


    public void assignStudentAndCourse(Integer student_id ,Integer course_id){
        Student student=studentRepository.findStudentById(student_id);
        Course course=courseRepository.findCourseById(course_id);

        if(course==null||student==null){
            throw new ApiException("course or student not found");
        }
        student.getCourse().add(course);
        course.getStudent().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }



    public void changeMajor(Integer student_id,String major){
        Student student=studentRepository.findStudentById(student_id);
        if(student==null){
            throw new ApiException("Student id not found ");
        }
        student.setMajor(major);
        student.getCourse().clear();
        studentRepository.save(student);
    }
}
