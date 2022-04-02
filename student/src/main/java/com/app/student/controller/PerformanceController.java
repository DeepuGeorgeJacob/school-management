package com.app.student.controller;

import com.app.student.dto.PerformanceDto;
import com.app.student.model.ApiResponse;
import com.app.student.model.Performance;
import com.app.student.model.Student;
import com.app.student.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/students/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<List<PerformanceDto>>> getPerformances() {
        return ResponseEntity.ok(performanceService.getStudentPerformance());
    }
}
