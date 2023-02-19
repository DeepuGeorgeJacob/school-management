package com.school.management.library.feign.client;

import com.school.management.common.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

//@FeignClient(url = "${student.service.url}", value = "student-feign-client", path = "api/students/")
//@FeignClient(value = "student-service", path = "api/students/")
@FeignClient(value = "api-gateway", path = "student-service/api/students/")
public interface StudentFeignClient {

    @GetMapping("/{id}")
    ApiResponse<Map<String,Object>> getStudentById(@RequestHeader HttpHeaders headers, @PathVariable int id);

}
