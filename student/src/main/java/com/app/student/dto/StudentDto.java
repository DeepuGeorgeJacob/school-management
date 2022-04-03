package com.app.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastname;
    private GuardianDto guardian;
    private PerformanceDto performance;
    private StudentDetailsDto studentDetails;
}
