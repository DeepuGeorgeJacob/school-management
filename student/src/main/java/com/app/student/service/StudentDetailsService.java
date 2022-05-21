package com.app.student.service;

import com.app.student.model.ApiResponse;
import com.app.student.model.StudentDetails;
import com.app.student.repository.StudentDetailsRepository;
import com.app.student.request.StudentDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    public ApiResponse<Boolean> updateStudentDetails(final StudentDetailsRequest studentDetailsRequest) {
        final StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(studentDetailsRequest.getId());
        studentDetails.setAge(studentDetailsRequest.getAge());
        studentDetails.setDateOfBirth(studentDetailsRequest.getDateOfBirth());
        studentDetails.setContactNumber(studentDetailsRequest.getContactNumber());
        studentDetailsRepository.save(studentDetails);
        return ApiResponse.<Boolean>builder().data(true).build();
    }
}
