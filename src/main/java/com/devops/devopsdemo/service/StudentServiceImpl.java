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
    public void saveStudent(StudentDTO studentDTO) {
        Map<String, String> map = NicCalc.getDobAndGender(studentDTO.getNic());
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.setNic(studentDTO.getNic());
        studentDAO.setName(studentDTO.getName());
        studentDAO.setGender(map.get("gender"));
        studentDAO.setDob(map.get("dob"));
        studentDAO.setYear(studentDTO.getYear());
        studentDAO.setCourse(studentDTO.getCourse());
        studentRepository.save(studentDAO);
    }

    @Override
    public Optional<StudentDAO> getStudentById(String nic) {
        return studentRepository.findById(nic);
    }

    @Override
    public void deleteStudent(String nic) {
        studentRepository.deleteById(nic);
    }

    @Override
    public Optional<List<StudentDAO>> getAllStudents() {
        return Optional.of(studentRepository.findAll());
    }
}
