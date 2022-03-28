package com.app.student.service;

import com.app.student.exception.DataNotFoundException;
import com.app.student.model.ApiResponse;
import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ApiResponse<List<Student>> getStudents() {
        return ApiResponse.<List<Student>>builder().data(studentRepository.findAll()).build();
    }

    public ApiResponse<List<Student>> addStudent(final Student student) {
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

    public ApiResponse<List<Student>> deleteStudent(final Student student) {
        studentRepository.delete(student);
        return getStudents();
    }


    public ApiResponse<List<Student>> deleteStudentById(final int id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return getStudents();
        } else {
            throw new DataNotFoundException("Student not found");
        }
    }

}
