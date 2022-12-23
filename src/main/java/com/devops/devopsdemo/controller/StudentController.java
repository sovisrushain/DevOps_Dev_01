package com.devops.devopsdemo.controller;

import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void saveStudent(@RequestBody  StudentDTO studentDTO) {
        logger.info("student controller class: post student - {}", studentDTO);
        studentService.saveStudent(studentDTO);
    }
}
