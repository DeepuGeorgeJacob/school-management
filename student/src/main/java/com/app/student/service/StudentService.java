package com.app.student.service;

import com.app.student.dto.GuardianDto;
import com.app.student.dto.PerformanceDto;
import com.app.student.dto.StudentDetailsDto;
import com.app.student.dto.StudentDto;
import com.app.student.exception.DataNotFoundException;
import com.app.student.model.*;
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
                                    .id(student.getId())
                                    .firstName(student.getFirstName())
                                    .lastName(student.getLastName())
                                    .guardian(getGuardian(guardian))
                                    .performance(getPerformance(performance))
                                    .studentDetails(getStudentDetails(studentDetails))
                                    .courses(student.getCourses().parallelStream().map(Course::getName).collect(Collectors.toSet()))
                                    .build();
                        }
                ).collect(Collectors.toList())
        ).build();
    }

    private GuardianDto getGuardian(Guardian guardian) {
        if (guardian != null) {
            return GuardianDto.builder()
                    .contactNumber(guardian.getContactNumber())
                    .name(guardian.getName())
                    .build();
        }
        return null;
    }

    private PerformanceDto getPerformance(Performance performance) {
        if (performance != null) {
            return PerformanceDto.builder()
                    .lastPerformance(performance.getLastPerformance())
                    .bestPerformance(performance.getBestPerformance())
                    .build();
        }
        return null;
    }

    private StudentDetailsDto getStudentDetails(StudentDetails studentDetails) {
        if (studentDetails != null) {
            return StudentDetailsDto.builder()
                    .id(studentDetails.getId())
                    .age(studentDetails.getAge())
                    .dateOfBirth(studentDetails.getDateOfBirth())
                    .contactNumber(studentDetails.getContactNumber())
                    .build();
        }
        return null;
    }

    public ApiResponse<List<StudentDto>> addStudent(final Student student) {
        studentRepository.save(student);
        return getStudents();

    }

    public ApiResponse<StudentDto> getStudent(int id) throws DataNotFoundException {
        final Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            final Student selectedStudent = optionalStudent.get();
            final StudentDetails selectedStudentDetails = selectedStudent.getStudentDetails();
            final StudentDto studentDto = StudentDto.builder().
                    id(selectedStudent.getId()).
                    firstName(selectedStudent.getFirstName()).
                    lastName(selectedStudent.getLastName()).
                    studentDetails(StudentDetailsDto.builder().
                            id(selectedStudentDetails.getId()).
                            contactNumber(selectedStudentDetails.getContactNumber()).
                            dateOfBirth(selectedStudentDetails.getDateOfBirth()).
                            build()).
                    courses(selectedStudent.getCourses().parallelStream().map(Course::getName).collect(Collectors.toSet())).
                    build();
            return ApiResponse.<StudentDto>builder().data(studentDto).build();
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
