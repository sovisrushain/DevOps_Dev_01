package com.devops.devopsdemo.service;

import com.devops.devopsdemo.dao.StudentDAO;
import com.devops.devopsdemo.dto.StudentDTO;
import com.devops.devopsdemo.repository.StudentRepository;
import com.devops.devopsdemo.util.NicCalc;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public String saveStudent(StudentDTO studentDTO) {
        calcNicAndSaveDAO(studentDTO);
        return studentDTO.getNic();
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

    @Override
    public Optional<List<StudentDAO>> findStudentsByName(String name) {
        return Optional.ofNullable(studentRepository.findByName(name));
    }

    @Override
    public String saveStudentsFromExel(MultipartFile multipartFile) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) - 1; rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex);
                if (rowIndex == 0) {
                    continue;
                }
                String nic = String.valueOf(row.getCell(0));
                String name = String.valueOf(row.getCell(1));
                String year = String.valueOf(row.getCell(2));
                String course = String.valueOf(row.getCell(3));
                studentDTOList.add(new StudentDTO(nic, name, year, course));
            }
        } catch (IOException e) {
            return e.getMessage();
        }

        if(!studentDTOList.isEmpty()) {
            for (StudentDTO studentDTO : studentDTOList) {
                calcNicAndSaveDAO(studentDTO);
            }
        }
        return "Successfully saved!";
    }

    public void calcNicAndSaveDAO(StudentDTO studentDTO) {
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
    }

    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }
}