package com.school.management.student.controller;

import com.school.management.student.dto.StudentDto;
import com.school.management.common.response.ApiResponse;
import com.school.management.student.model.Student;
import com.school.management.student.request.StudentRequest;
import com.school.management.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<List<StudentDto>>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<Map<String, StudentDto>>> getStudent(@PathVariable final int id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ResponseEntity<ApiResponse<List<StudentDto>>> addStudent(@RequestBody final Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @DeleteMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ResponseEntity<ApiResponse<List<StudentDto>>> removeStudent(@RequestBody final Student student) {
        return ResponseEntity.ok(studentService.deleteStudent(student));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<List<StudentDto>>> deleteStudentById(@PathVariable final int id) {
        return ResponseEntity.ok(studentService.deleteStudentById(id));//new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,
            MediaType.TEXT_XML_VALUE})
    public ResponseEntity<ApiResponse<Boolean>> updateStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(studentRequest));
    }

}
