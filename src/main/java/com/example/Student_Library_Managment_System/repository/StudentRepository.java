package com.example.Student_Library_Managment_System.repository;

import com.example.Student_Library_Managment_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
