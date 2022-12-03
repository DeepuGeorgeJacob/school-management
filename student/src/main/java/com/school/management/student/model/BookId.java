package com.school.management.student.model;

import lombok.Data;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class BookId implements Serializable {
    private String author;
    private String name;
}
