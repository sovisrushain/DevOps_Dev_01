package com.devops.devopsdemo.controller;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class  StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> saveStudent(@Valid @RequestBody  StudentDTO studentDTO, Errors errors) {
        logger.info("student controller class: post student - {}", studentDTO);
        if(errors.hasErrors()) {
            logger.error("student controller class: validation errors occur during saving the student");
            return new ResponseEntity<>(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            String nic = studentService.saveStudent(studentDTO);
            logger.info("student controller class: save the student");
            return new ResponseEntity<>(nic, HttpStatus.OK);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> importExelData(@RequestParam("file")MultipartFile file) {
        String response = studentService.saveStudentsFromExel(file);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{nic}")
    public ResponseEntity<Optional<StudentDAO>> getStudent(@PathVariable String nic) {
        Optional<StudentDAO> student = studentService.getStudentById(nic);
        logger.info("student controller class: get the student of id - {} " , nic);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Optional<List<StudentDAO>>> getAllStudents() {
        Optional<List<StudentDAO>> studentList = studentService.getAllStudents();
        logger.info("student controller class: get all students");
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Optional<List<StudentDAO>>> findStudentsByName(@PathVariable String name) {
        Optional<List<StudentDAO>> students = studentService.findStudentsByName(name);
        logger.info("student controller class: find students by name");
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{nic}")
    public ResponseEntity<String> deleteStudent(@PathVariable String nic) {
        String nicNum = studentService.deleteStudent(nic);
        logger.info("student controller class: get a student - {}", nic);
        return new ResponseEntity<>(nicNum, HttpStatus.OK);
    }
}
