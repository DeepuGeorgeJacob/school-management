package com.school.management.library.service;

import com.school.management.library.feign.client.StudentFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentFeignClient studentFeignClient;

    @Autowired
    public StudentService(final StudentFeignClient studentFeignClient) {
        this.studentFeignClient = studentFeignClient;
    }

    @CircuitBreaker(name = "studentService", fallbackMethod = "getStudentByIdFallbackMethod")
    public Object getStudentById(final int id) {
        return studentFeignClient.getStudentById(id).getData().get("student");
    }

    public Object getStudentByIdFallbackMethod(final int id, final Throwable th) {
        return "Student details not found for student with id.. " + id + " No response from student server";
    }


}
