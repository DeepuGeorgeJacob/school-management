package com.school.management.student.model;

import lombok.Data;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
@Data
public class Book {
    @EmbeddedId
    private BookId id;
    private String genre;
    private Integer price;
}
