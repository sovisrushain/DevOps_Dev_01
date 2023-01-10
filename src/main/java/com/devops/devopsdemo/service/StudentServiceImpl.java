package com.devops.devopsdemo.service;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.repository.StudentRepository;
import com.devops.devopsdemo.util.NicCalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String saveStudent(StudentDTO studentDTO) {
        Map<String, String> map = NicCalc.getDobAndGender(studentDTO.getNic());
        StudentDAO student = StudentDAO.builder()
                .nic(studentDTO.getNic())
                .name(studentDTO.getName())
                .gender(map.get("gender"))
                .dob(map.get("dob"))
                .year(studentDTO.getYear())
                .course(studentDTO.getCourse())
                .build();
        studentRepository.save(student);
        return student.getNic();
    }

    @Override
    public Optional<StudentDAO> getStudentById(String nic) {
        return studentRepository.findById(nic);
    }

    @Override
    public String deleteStudent(String nic) {
        studentRepository.deleteById(nic);
        return nic;
    }

    @Override
    public Optional<List<StudentDAO>> getAllStudents() {
        return Optional.of(studentRepository.findAll());
    }
}
