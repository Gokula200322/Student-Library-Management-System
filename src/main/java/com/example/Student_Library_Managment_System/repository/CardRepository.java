package com.example.Student_Library_Managment_System.repository;

import com.example.Student_Library_Managment_System.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
