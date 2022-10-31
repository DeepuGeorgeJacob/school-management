package com.school.management.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceDto {
    private Integer id;
    private int bestPerformance;
    private int lastPerformance;
    private StudentDto student;
}
