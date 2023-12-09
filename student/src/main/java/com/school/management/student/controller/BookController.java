package com.school.management.student.controller;

import com.school.management.student.dto.BookDto;
import com.school.management.common.response.ApiResponse;
import com.school.management.student.request.BookRequest;
import com.school.management.student.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ApiResponse<BookDto> saveBook(@RequestBody final BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }
}
