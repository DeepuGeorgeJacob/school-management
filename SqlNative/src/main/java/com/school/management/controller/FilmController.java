package com.school.management.controller;

import com.school.management.repo.Film;
import com.school.management.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(value = "/list")
    public List<Film> getFilms() {
        return filmRepository.getFilms();
    }


    @GetMapping(value = "/year")
    public Integer getFilmReleaseYear() {
        return filmRepository.getFilmReleaseYear();
    }
}
