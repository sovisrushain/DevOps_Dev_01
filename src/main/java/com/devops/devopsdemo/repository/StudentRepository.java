package com.devops.devopsdemo.repository;

import com.devops.devopsdemo.dao.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDAO, String> {
}
