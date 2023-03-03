package com.school.management.student.service;

import com.school.management.student.model.Performance;
import com.school.management.student.model.Student;
import com.school.management.student.repository.PerformanceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PerformanceServiceTest {

    @Mock
    private PerformanceRepository performanceRepository;

    @InjectMocks
    private PerformanceService performanceService;

    @BeforeEach
    void setUp() {
        given(performanceRepository.findAll()).willReturn(getMockPerformances());
    }

    @Test
    void test_student_performance() {
        assertEquals(1, performanceService.getStudentPerformance().getData().size());
    }

    @Test
    void test_save_performance() {

    }


    @AfterEach
    void tearDown() {
    }

    private List<Performance> getMockPerformances() {
        final List<Performance> performances = new ArrayList<>() {
            {
                final Performance performance = new Performance();
                performance.setBestPerformance(100);
                performance.setLastPerformance(80);
                final Student student = new Student();
                student.setFirstName("A");
                student.setLastName("B");
                student.setId(1);
                performance.setStudent(student);
                add(performance);
            }
        };
        return performances;

    }
}