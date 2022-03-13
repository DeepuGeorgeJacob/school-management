package com.app.student.service;

import com.app.student.exception.DataNotFoundException;
import com.app.student.model.ApiResponse;
import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private ArrayList<Student> students = new ArrayList<>() {
        {
            add(new Student(1, "First student", "First student last name", 18));
            add(new Student(2, "Second student", "Second student last name", 25));
            add(new Student(3, "Third student", "Third student last name", 26));
        }
    };

    public ApiResponse<List<Student>> getStudents() {
        return new ApiResponse<>(null, students);
    }

    public ApiResponse<List<Student>> addStudent(final Student student) {
        studentRepository.save(student);
        students.add(student);
        return new ApiResponse<>(null, students);

    }

    public ApiResponse<Student> getStudent(int id) throws DataNotFoundException {
        final Optional<Student> optionalStudent = students.stream().filter(student -> student.getId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            final Student selectedStudent = optionalStudent.get();
            return new ApiResponse<>(null,selectedStudent);
        } else {
            throw new DataNotFoundException("Student not found");
        }
    }

}
