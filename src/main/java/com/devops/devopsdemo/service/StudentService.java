package com.devops.devopsdemo.service;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;

import java.util.Optional;

public interface StudentService {
    void saveStudent(StudentDTO studentDTO);
    Optional<StudentDAO> getStudentById(String nic);
    void deleteStudent(String nic);
}
