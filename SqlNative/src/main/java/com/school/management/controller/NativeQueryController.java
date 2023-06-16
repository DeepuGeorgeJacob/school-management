package com.school.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NativeQueryController {

    @GetMapping(value = "/hello")
    public String greetings() {
        return "Hello world";
    }
}
