package com.school.management.controller;

import com.school.management.repo.Film;
import com.school.management.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NativeQueryController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(value = "/hello")
    public List<Film> getFilms() {
        return filmRepository.getFilms();
    }
}
