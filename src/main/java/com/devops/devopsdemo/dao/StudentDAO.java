package com.devops.devopsdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class StudentDAO {
    @Id
    private String nic;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private String course;
}
