package com.devops.devopsdemo.controller;

import com.devops.devopsdemo.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping
    public void saveStudent(@RequestBody  StudentDTO studentDTO) {
        logger.info("student controller class: post student - {}", studentDTO);

    }
}
