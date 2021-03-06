package com.app.student.controller;

import com.app.student.dto.BookDto;
import com.app.student.model.ApiResponse;
import com.app.student.request.BookRequest;
import com.app.student.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.TEXT_XML_VALUE,
            MediaType.TEXT_XML_VALUE
    })
    public ApiResponse<BookDto> saveBook(@RequestBody final BookRequest bookRequest) {
        return bookService.saveBook(bookRequest);
    }
}
