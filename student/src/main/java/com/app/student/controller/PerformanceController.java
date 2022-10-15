package com.app.student.controller;

import com.app.student.dto.PerformanceDto;
import com.common.response.ApiResponse;
import com.app.student.request.PerformanceRequest;
import com.app.student.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<Boolean>> saveOrUpdatePerformance(@RequestBody final PerformanceRequest performanceRequest) {
        return ResponseEntity.ok(performanceService.saveOrUpdatePerformance(performanceRequest));
    }
}
