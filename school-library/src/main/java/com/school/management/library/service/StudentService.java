package com.school.management.library.service;

import com.school.management.library.feign.client.StudentFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentFeignClient studentFeignClient;

    @Autowired
    public StudentService(final StudentFeignClient studentFeignClient) {
        this.studentFeignClient = studentFeignClient;
    }

    @CircuitBreaker(name = "studentService", fallbackMethod = "getStudentByIdFallbackMethod")
    public Object getStudentById(final int id) {
        logger.info("Student feign client to get student data");
        return studentFeignClient.getStudentById(id).getData().get("student");
    }

    public Object getStudentByIdFallbackMethod(final int id, final Throwable th) {
        logger.error("Failed to get student details", th);
        return "Student details not found for student with id.. " + id + " No response from student server";
    }


}
