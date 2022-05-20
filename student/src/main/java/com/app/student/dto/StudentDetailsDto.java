package com.app.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class StudentDetailsDto {
    private int id;
    private int age;
    private String dateOfBirth;
    private String contactNumber;
}
