package com.app.student.request;

import lombok.Data;

@Data
public class StudentDetailsRequest {
    private Integer id;
    private int age;
    private String dateOfBirth;
    private String contactNumber;
}
