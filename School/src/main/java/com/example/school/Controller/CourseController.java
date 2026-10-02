package com.example.school.Controller;

import com.example.school.Api.ApiResponse;
import com.example.school.Model.Course;
import com.example.school.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200).body(courseService.get());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity<?> add(@PathVariable Integer teacher_id, @RequestBody @Valid Course course) {

        courseService.add(teacher_id, course);

        return ResponseEntity.status(200).body(new ApiResponse("Add successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Course course) {

        courseService.update(id, course);

        return ResponseEntity.status(200).body(new ApiResponse("Update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        courseService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Delete successfully"));
    }

    @GetMapping("/teacher/{course_id}")
    public ResponseEntity<?> getTeacherByCourseId(@PathVariable Integer course_id) {
        return ResponseEntity.status(200).body(courseService.getTeacherByCourseId(course_id));
    }

    @GetMapping("/students/{course_id}")
    public ResponseEntity<?> getStudents(@PathVariable Integer course_id) {

        return ResponseEntity.status(200).body(courseService.getStudent(course_id));
    }
}