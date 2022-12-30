package com.devops.devopsdemo.controller;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
public class  StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void saveStudent(@Valid @RequestBody  StudentDTO studentDTO) {
        logger.info("student controller class: post student - {}", studentDTO);
        studentService.saveStudent(studentDTO);
    }

    @GetMapping("/{nic}")
    public Optional<StudentDAO> getStudent(@PathVariable String nic) {
        logger.info("student controller class: get a student - {}", nic);
        return studentService.getStudentById(nic);
    }

    @DeleteMapping("/{nic}")
    public void deleteStudent(@PathVariable String nic) {
        logger.info("student controller class: get a student - {}", nic);
        studentService.deleteStudent(nic);
    }
}
