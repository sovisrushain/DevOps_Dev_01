package com.devops.devopsdemo.controller;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
public class  StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@Valid @RequestBody  StudentDTO studentDTO) {
        logger.info("student controller class: post student - {}", studentDTO);
        String nic = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(nic, HttpStatus.OK);
    }

    @GetMapping("/{nic}")
    public ResponseEntity<Optional<StudentDAO>> getStudent(@PathVariable String nic) {
        logger.info("student controller class: get a student - {}", nic);
        Optional<StudentDAO> student = studentService.getStudentById(nic);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Optional<List<StudentDAO>>> getAllStudents() {
        logger.info("student controller class: get all students");
        Optional<List<StudentDAO>> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @DeleteMapping("/{nic}")
    public ResponseEntity<String> deleteStudent(@PathVariable String nic) {
        logger.info("student controller class: get a student - {}", nic);
        String nicNum = studentService.deleteStudent(nic);
        return new ResponseEntity<>(nicNum, HttpStatus.OK);
    }
}
