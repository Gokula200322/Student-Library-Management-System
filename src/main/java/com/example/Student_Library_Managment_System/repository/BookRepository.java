package com.example.Student_Library_Managment_System.repository;

import com.example.Student_Library_Managment_System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
