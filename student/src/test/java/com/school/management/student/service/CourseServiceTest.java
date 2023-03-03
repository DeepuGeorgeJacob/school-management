package com.school.management.student.service;

import com.school.management.student.model.Course;
import com.school.management.student.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock(name = "courseRepository")
    private CourseRepository courseRepositoryMock;

    @InjectMocks
    private CourseService courseService;


    @Test
    void save_course() {
        final Course course = new Course();
        course.setName("SampleCourse");
        given(courseRepositoryMock.save(course)).willReturn(course);
        assertTrue(courseService.saveCourse("SampleCourse").getData());
    }

    @Test
    void get_all_available_courses() {
        given(courseRepositoryMock.findAll()).willReturn(getMockCourses());
        assertEquals(2, courseService.getCourses().getData().get("courses").size());
    }

    private List<Course> getMockCourses() {
        final Course course1 = new Course();
        course1.setName("A");
        final Course course2 = new Course();
        course2.setName("B");
        return List.of(course1, course2);
    }
}