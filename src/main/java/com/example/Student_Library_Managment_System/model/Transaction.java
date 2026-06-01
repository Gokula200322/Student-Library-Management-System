package com.example.Student_Library_Managment_System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
public class Transaction {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)// AUTOMATED Increment for every record inserted
    private int id;

    @Column(name = "TransactionDate", nullable = false)
    @CreationTimestamp
    private Date TransactionDate;

    @Column(name ="dueDate",nullable = false)
    private String dueDate ;

    @Column(name = "transactionType", nullable = false)
    private String transactionType;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Book book;



}
