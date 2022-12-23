package com.devops.devopsdemo.service;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.util.NicCalc;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {


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

        System.out.println("===================");
        System.out.println(studentDAO.toString());
    }
}
