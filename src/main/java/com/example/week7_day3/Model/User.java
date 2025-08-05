package com.example.week7_day3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    //User class: ID , name , username , password, email ,role, age

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private  Integer id;


    @NotEmpty(message = "Name must be not empty")
    @Size(min = 5 , message = "Name length must be more than 4 character ")
    @Column(columnDefinition = "varchar(30) not null")
    private String name ;


    @NotEmpty(message = "User Name must be not empty")
    @Size(min = 5 , message = "User name length must be more than 4 character ")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;


    @NotEmpty(message = "Password must be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;


    @Email(message = "Email must be correct")
    @NotEmpty(message = "Password must be not empty")
    @Column(columnDefinition = "varchar(200) not null unique")
    private String email;



    @Pattern(regexp = "^(?i)(user|admin)$" ,message = "Role must be user or admin only")
    @NotEmpty(message = "Role must be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String role;

    @NotNull(message = "Age must be not Null")
    @Column(columnDefinition = "int  not null")
    private Integer age;

}
