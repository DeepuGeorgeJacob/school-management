package com.school.management.student.request;

import lombok.Data;

@Data
public class BookRequest {
    private String author;
    private String name;
    private String genre;
    private Integer price;

}
