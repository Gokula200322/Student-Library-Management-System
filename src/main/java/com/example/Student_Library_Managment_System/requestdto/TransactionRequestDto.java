package com.example.Student_Library_Managment_System.requestdto;

import lombok.Data;

@Data
public class TransactionRequestDto {

    //request dto(data transfer object) - it is used to take inputs into APIs.

    private String dueDate;
    private String transactionType;

    private int cardId;
    private int bookId;

}
