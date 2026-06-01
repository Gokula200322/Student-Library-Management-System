package com.example.Student_Library_Managment_System.requestdto;

import lombok.Data;

@Data
public class StudentRequestDto {

    //request dto(data transfer object) - it is used to take inputs into APIs.

    private String name;
    private String email;
    private String mobile;
    private String dept;
    private int sem;
    private String gender;
    private String address;

}
