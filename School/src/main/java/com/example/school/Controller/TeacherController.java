package com.example.school.Controller;


import com.example.school.Api.ApiResponse;
import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;

    @GetMapping("/get")
    private ResponseEntity<?>get(){
        return ResponseEntity.status(200).body(teacherService.get());
    }

    @PostMapping("/add")
    private ResponseEntity<?>add(@RequestBody @Valid Teacher teacher){
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Add successfully"));

    }
    @PutMapping("/update/{id}")
    private ResponseEntity<?>update(@PathVariable Integer id, @RequestBody @Valid Teacher teacher){
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete successfully"));
    }
    @GetMapping("get/details/{id}")
    public ResponseEntity<?>getDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.details(id));
    }

}
