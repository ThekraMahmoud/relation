package com.example.school.Controller;

import com.example.school.Api.ApiResponse;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Teacher;
import com.example.school.Repository.AddressRepository;
import com.example.school.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService ;

    @GetMapping("/get")
    private ResponseEntity<?> get(){
        return ResponseEntity.status(200).body(addressService.get());
    }

    @PostMapping("/add")
    private ResponseEntity<?>add(@RequestBody @Valid AddressDTO addressDTO){
        addressService.add(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Add successfully"));

    }
    @PutMapping("/update")
    private ResponseEntity<?>update(@RequestBody @Valid AddressDTO addressDTO){
        addressService.update(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable Integer id){
        addressService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete successfully"));
    }

}

