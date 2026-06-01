package com.example.Student_Library_Managment_System.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.internal.TransactionManagement;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "Book")
@Data
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// AUTOMATED Increment for every record inserted
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisherName", nullable = false)
    private String publisherName;

    @Column(name = "publishedDate", nullable = false)
    private String publishedDate;

    @Column(name = "pages")
    private int pages;

    @Column(name ="availability", nullable = false)
    private boolean availability;

    @Column(name ="category",nullable = false)
    private String category;

    @Column(name = "rackNo", nullable = false)
    private String rackNo;

    @JoinColumn
    @ManyToOne
    private Card card;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transaction;


}
