package com.app.student.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Book {
    @EmbeddedId
    private BookId id;
    private String genre;
    private Integer price;
}
