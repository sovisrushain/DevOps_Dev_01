package com.devops.devopsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private Date bod;
    private int year;
    private Course[] courses;
}
