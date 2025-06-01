package com.edutech.classroom.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

    private Long id;
    private String name;
    private String email;



    public Student() {}

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}