package com.school.management.student.controller;

import com.school.management.common.response.ApiResponse;
import com.school.management.student.request.StudentDetailsRequest;
import com.school.management.student.service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/details")
public class StudentDetailsController {

    private final StudentDetailsService studentDetailsService;


    @Autowired
    public StudentDetailsController(final StudentDetailsService studentDetailsService) {
        this.studentDetailsService = studentDetailsService;
    }

    @PutMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.TEXT_XML_VALUE,
                    MediaType.TEXT_XML_VALUE
            }
    )
    public ResponseEntity<ApiResponse<Boolean>> updateDetails(
            @RequestBody StudentDetailsRequest studentDetailsRequest) {
        return ResponseEntity.ok(studentDetailsService.updateStudentDetails(studentDetailsRequest));

    }
}
