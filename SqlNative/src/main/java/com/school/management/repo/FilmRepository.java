package com.school.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Demo,String> {

    @Query(value = "SELECT title,description FROM film;",nativeQuery = true)
    public List<Film> getFilms();

}
