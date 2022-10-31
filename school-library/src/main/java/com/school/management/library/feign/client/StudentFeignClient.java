package com.school.management.library.feign.client;

import com.school.management.common.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

//@FeignClient(url = "${student.service.url}", value = "student-feign-client", path = "api/students/")
@FeignClient(value = "student-service", path = "api/students/")
public interface StudentFeignClient {

    @GetMapping("/{id}")
    ApiResponse<Map<String,Object>> getStudentById(@PathVariable int id);

}
