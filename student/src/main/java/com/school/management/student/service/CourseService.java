package com.school.management.student.service;

import com.school.management.common.response.ApiResponse;
import com.school.management.student.dto.CourseDto;
import com.school.management.student.model.Course;
import com.school.management.student.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    private CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ApiResponse<Boolean> saveCourse(final String courseName) {
        final Course course = new Course();
        course.setName(courseName);
        courseRepository.save(course);
        return ApiResponse.<Boolean>builder().data(true).build();
    }

    public ApiResponse<Map<String, List<CourseDto>>> getCourses() {
        var data = courseRepository.findAll().parallelStream().map(course -> new CourseDto(
                course.getId(),
                course.getName())).toList();
        return ApiResponse.<Map<String, List<CourseDto>>>builder().data(Map.of("courses", data)).build();
    }

}
