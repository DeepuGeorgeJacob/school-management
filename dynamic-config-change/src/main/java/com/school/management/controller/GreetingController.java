package com.school.management.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class GreetingController {

    @Value("${app.greetings}")
    String greetings;

    @GetMapping(value = "/greetings")
    public String showGreetings() {
        return greetings;
    }

}
