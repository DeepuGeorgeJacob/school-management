package com.app.student.service;

import com.app.student.dto.GuardianDto;
import com.app.student.dto.PerformanceDto;
import com.app.student.dto.StudentDetailsDto;
import com.app.student.dto.StudentDto;
import com.app.student.exception.DataNotFoundException;
import com.app.student.model.ApiResponse;
import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ApiResponse<List<StudentDto>> getStudents() {
        return ApiResponse.<List<StudentDto>>builder().data(studentRepository.findAll().parallelStream().map(
                        student -> {
                            var guardian = student.getGuardian();
                            var performance = student.getPerformance();
                            var studentDetails = student.getStudentDetails();
                            return StudentDto.builder()
                                    .firstName(student.getFirstName())
                                    .lastname(student.getLastName())
                                    .guardian(GuardianDto.builder()
                                            .contactNumber(guardian.getContactNumber())
                                            .name(guardian.getName())
                                            .build())
                                    .performance(PerformanceDto.builder()
                                            .lastPerformance(performance.getLastPerformance())
                                            .bestPerformance(performance.getBestPerformance())
                                            .build())
                                    .studentDetails(StudentDetailsDto.builder()
                                            .age(studentDetails.getAge())
                                            .dateOfBirth(studentDetails.getDateOfBirth())
                                            .contactNumber(studentDetails.getContactNumber())
                                            .build())
                                    .build();
                        }
                ).collect(Collectors.toList())
        ).build();
    }

    public ApiResponse<List<StudentDto>> addStudent(final Student student) {
        studentRepository.save(student);
        return getStudents();

    }

    public ApiResponse<Student> getStudent(int id) throws DataNotFoundException {
        final Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            final Student selectedStudent = optionalStudent.get();
            return ApiResponse.<Student>builder().data(selectedStudent).build();
        } else {
            throw new DataNotFoundException("Student not found");
        }
    }

    public ApiResponse<List<StudentDto>> deleteStudent(final Student student) {
        studentRepository.delete(student);
        return getStudents();
    }


    public ApiResponse<List<StudentDto>> deleteStudentById(final int id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return getStudents();
        } else {
            throw new DataNotFoundException("Student not found");
        }
    }

}
