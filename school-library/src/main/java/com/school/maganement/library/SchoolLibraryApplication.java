package com.school.maganement.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SchoolLibraryApplication {
    @Value("${student.service.url}")
    private String studentUrl;

    public static void main(String[] args) {
        SpringApplication.run(SchoolLibraryApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        System.out.println(studentUrl);
        WebClient webClient = WebClient.builder().baseUrl(studentUrl).build();
        return webClient;
    }
}
