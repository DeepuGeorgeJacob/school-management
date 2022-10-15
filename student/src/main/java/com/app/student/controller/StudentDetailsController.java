package com.app.student.controller;

import com.common.response.ApiResponse;
import com.app.student.request.StudentDetailsRequest;
import com.app.student.service.StudentDetailsService;
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

    @Autowired
    private StudentDetailsService studentDetailsService;

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
