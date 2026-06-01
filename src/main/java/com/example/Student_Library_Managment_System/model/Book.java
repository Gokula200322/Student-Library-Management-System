package com.example.Student_Library_Managment_System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference// it prints the data already in the previous linked class, we do not need to print again here so infintie loop pf printing of data is prevented
    @JoinColumn
    @ManyToOne
    private Card card;

    @JsonManagedReference// we manage by printing the data here of the linked next class so infinte loop of printing of data is prevented
    @OneToMany(mappedBy = "book")
    private List<Transaction> transaction;


}
