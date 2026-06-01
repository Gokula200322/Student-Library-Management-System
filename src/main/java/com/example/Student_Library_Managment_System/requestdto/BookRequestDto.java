package com.example.Student_Library_Managment_System.requestdto;

import lombok.Data;

@Data
public class BookRequestDto {

    //request dto(data transfer object) - it is used to take inputs into APIs.

    private String title;
    private String publisherName;
    private String publishedDate;
    private int pages;
    private boolean availability;
    private String category;
    private String rackNo;

    private int cardId;
}
