package com.example.Student_Library_Managment_System.requestdto;

import lombok.Data;

@Data
public class CardRequestDto {

    //request dto(data transfer object) - it is used to take inputs into APIs.

    private String cardStatus;
    private String expiryDate;

    private int studentId;

}
