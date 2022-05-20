package com.app.student.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookDto {
    private String author;
    private String name;
    private String genre;
    private Integer price;
}
