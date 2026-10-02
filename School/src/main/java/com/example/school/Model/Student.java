package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "enter name please ")
    @Column(columnDefinition = "varchar (10) not null ")
    private String name;

    @NotNull(message = "int not null ")
    @Min(value = 7, message = "age must be 7 or older")
    @Column(columnDefinition = "int check(age >=7)")
    private Integer age;



    @NotBlank(message = "enter name please ")
    @Column(columnDefinition = "varchar (20) not null ")
    private String major;



    @ManyToMany
    @JsonIgnore
    private Set<Course> course;
}
