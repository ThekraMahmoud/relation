package com.example.school.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

//بيانات من الجدول
public class AddressDTO {
    @NotNull(message = "please Enter area")
    @Positive(message = "It must be greater than zero")
    private Integer area;


    @NotBlank(message = "please enter street ")
    private String street;

    @NotNull(message = "please enter building Number")
    @Positive(message = "Building number must be greater than zero")
    private Integer buildingNumber;

    private Integer teacher_id
            ;
}
