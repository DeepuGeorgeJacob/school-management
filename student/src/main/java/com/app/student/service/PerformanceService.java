package com.app.student.service;

import com.app.student.dto.PerformanceDto;
import com.app.student.dto.StudentDto;
import com.app.student.model.ApiResponse;
import com.app.student.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    public ApiResponse<List<PerformanceDto>> getStudentPerformance() {
        var result = performanceRepository.findAll().parallelStream().map(
                performance -> {
                    var student = performance.getStudent();
                    return PerformanceDto.builder()
                            .bestPerformance(performance.getBestPerformance())
                            .lastPerformance(performance.getLastPerformance())
                            .student(
                                    StudentDto.builder()
                                            .firstName(student.getFirstName())
                                            .lastName(student.getLastName())
                                            .build()
                            ).build();
                }
        ).collect(Collectors.toList());
        return ApiResponse.<List<PerformanceDto>>builder().data(result).build();
    }
}
