
package com.example.school.Controller;

import com.example.school.Api.ApiResponse;
import com.example.school.Model.Student;
import com.example.school.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> get() {
        return ResponseEntity.status(200)
                .body(studentService.get());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid Student student) {
        studentService.add(student);

        return ResponseEntity.status(200).body(new ApiResponse("Add successfully"));
    }

    @PutMapping("/update/{student_id}")
    public ResponseEntity<?> update(@PathVariable Integer student_id, @RequestBody  Student student) {

        studentService.update(student_id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Update successfully"));
    }

    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity<?> delete(@PathVariable Integer student_id) {

        studentService.delete(student_id);
        return ResponseEntity.status(200).body(new ApiResponse("Delete successfully"));
    }

    @PostMapping("/assign/{student_id}/{course_id}")
    public ResponseEntity<?> assignStudentAndCourse(@PathVariable Integer student_id, @PathVariable Integer course_id) {

        studentService.assignStudentAndCourse(student_id, course_id);

        return ResponseEntity.status(200).body(new ApiResponse("Student assigned to course successfully"));
    }

    @PutMapping("/change-major/{student_id}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer student_id, @RequestParam String major) {

        studentService.changeMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("Major updated and courses cleared successfully"));
    }
}
