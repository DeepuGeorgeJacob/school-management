package com.school.management.student.service;

import com.school.management.student.dto.PerformanceDto;
import com.school.management.student.dto.StudentDto;
import com.school.management.common.response.ApiResponse;
import com.school.management.student.model.Performance;
import com.school.management.student.repository.PerformanceRepository;
import com.school.management.student.request.PerformanceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceService(final PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

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

    @Transactional
    public ApiResponse<Boolean> saveOrUpdatePerformance(final PerformanceRequest performanceRequest) {
        if (performanceRequest.getPerformanceId() == null) {
            insertPerformanceData(performanceRequest);
        } else {
            final Optional<Performance> performanceOptional = performanceRepository.findById(performanceRequest.getPerformanceId());
            if (performanceOptional.isPresent()) {
                final Performance performance = performanceOptional.get();
                performance.setBestPerformance(performanceRequest.getBestPerformance());
                performance.setLastPerformance(performanceRequest.getLastPerformance());
                performanceRepository.save(performance);
            } else {
                insertPerformanceData(performanceRequest);
            }
        }
        return ApiResponse.<Boolean>builder().data(true).build();
    }

    private void insertPerformanceData(final PerformanceRequest performanceRequest) {
        performanceRepository.insertPerformanceData(
                performanceRequest.getBestPerformance(),
                performanceRequest.getLastPerformance(),
                performanceRequest.getStudentId());
    }
}
