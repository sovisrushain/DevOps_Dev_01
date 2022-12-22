package com.devops.devopsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String nic;
    private String name;
    private int year;
    private CourseDTO[] courses;
}
