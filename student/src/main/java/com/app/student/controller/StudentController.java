package com.app.student.controller;

import com.app.student.dto.StudentDto;
import com.app.student.model.ApiResponse;
import com.app.student.model.Student;
import com.app.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

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
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable final int id) {
        return ResponseEntity.ok(studentService.getStudent(id));//new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
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

}
