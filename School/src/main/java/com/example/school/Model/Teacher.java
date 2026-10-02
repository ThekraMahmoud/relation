package com.example.school.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Entity
@Setter
@Getter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "enter name please ")
    @Column(columnDefinition = "varchar (10) not null ")
    private String name;

    @NotNull(message = "int not null ")
    @Min(value = 23, message = "age must be 23 or older")
    @Column(columnDefinition = "int check(age >=23)")
    private Integer age;

    @Email
    @NotEmpty(message = "please enter message")
    @Column(columnDefinition = "varchar(30) not null")
    private String email;

    @NotNull(message = "please enter your salary")
    @Min(value = 1000, message = "Salary must be at least 1000")
    @Column(columnDefinition = "int not null check (salary >=1000)")
    private Integer salary;


    @OneToOne(cascade = CascadeType.ALL ,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher1")
    private Set<Course>courses;

}
