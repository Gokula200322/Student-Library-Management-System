package com.example.Student_Library_Managment_System.model;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
@Data
public class Card {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// AUTOMATED Increment for every record inserted
    private int id;

    @Column(name = "cardStatus",nullable = false)
    private String cardStatus;

    @Column(name = "expiryDate",nullable = false)
    private String expiryDate;

    @Column(name = "createdDate",nullable = false)
    @CreationTimestamp // when new card is created /issued , it will automatically add date and time
    private Date createdDate;

    @Column(name = "updatedDate", nullable = false)
    @UpdateTimestamp // when a card is updated then it will automatically update the date and time.
    private Date updatedDate;

    @JoinColumn// it joins the PK of student table with the card table and acts as a FK;
    @OneToOne // one card will be assigned to one student;
    private Student student;

    @OneToMany(mappedBy = "card")
    private List<Book> book;

    @OneToMany(mappedBy = "card")
    private List<Transaction> transaction;




}
