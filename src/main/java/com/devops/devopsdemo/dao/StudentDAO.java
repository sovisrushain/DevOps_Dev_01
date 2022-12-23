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
    private Date dob;
    private String gender;
    private int year;
    private String course;
}
