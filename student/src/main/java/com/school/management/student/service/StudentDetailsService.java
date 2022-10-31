package com.school.management.student.service;

import com.school.management.common.response.ApiResponse;
import com.school.management.student.model.StudentDetails;
import com.school.management.student.repository.StudentDetailsRepository;
import com.school.management.student.request.StudentDetailsRequest;
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
