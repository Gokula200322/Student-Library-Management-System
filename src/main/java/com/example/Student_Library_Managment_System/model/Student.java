package com.example.Student_Library_Managment_System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// AUTOMATED Increment for every record inserted
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "dept", nullable = false)
    private String dept;

    @Column(name = "sem" , nullable = false)
    private int sem;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "address",nullable = false)
    private String address;

    @JsonManagedReference
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)// one student will have one card
    // casecade - if student gets created , a card also is created and if student deleted , card also deleted.
    private Card card;






}
