package com.app.student.controller;

import com.app.student.dto.CourseDto;
import com.app.student.model.ApiResponse;
import com.app.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ApiResponse<Boolean> saveCourse(@RequestBody final String courseName) {
        return courseService.saveCourse(courseName);
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ApiResponse<Map<String, List<CourseDto>>> getCourses() {
        return courseService.getCourses();
    }
}
