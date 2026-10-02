package com.example.school.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "Course name must not be empty")
    @Column(columnDefinition = "varchar (20) not null ")
    private String name;



    @ManyToOne
    @JoinColumn
    private Teacher teacher1;



    @ManyToMany(mappedBy = "course")
    private Set <Student> student;
}
