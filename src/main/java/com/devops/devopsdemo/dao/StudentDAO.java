package com.devops.devopsdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDAO {
    private String nic;
    private String name;
    private String gender;
    private String dob;
    private int year;
    private String course;
}
