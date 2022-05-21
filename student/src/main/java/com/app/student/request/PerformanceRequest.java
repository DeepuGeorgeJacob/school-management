package com.app.student.request;

import lombok.Data;

@Data
public class PerformanceRequest {
    private Integer studentId;
    private Integer performanceId;
    private int bestPerformance;
    private int lastPerformance;
}
