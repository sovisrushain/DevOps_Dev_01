package com.devops.devopsdemo.repository;

import com.devops.devopsdemo.dao.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentDAO, String> {
    @Query(value = "SELECT s FROM StudentDAO s WHERE s.name LIKE %:name%")
    List<StudentDAO> findByName(@Param("name") String name);
}
