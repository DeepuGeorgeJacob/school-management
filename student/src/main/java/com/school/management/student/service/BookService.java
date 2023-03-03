package com.school.management.student.service;

import com.school.management.student.dto.BookDto;
import com.school.management.common.exception.handler.DataNotFoundException;
import com.school.management.common.response.ApiResponse;
import com.school.management.student.model.Book;
import com.school.management.student.model.BookId;
import com.school.management.student.repository.BookRepository;
import com.school.management.student.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;


    @Autowired
    private BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ApiResponse<BookDto> saveBook(final BookRequest bookRequest) {
        final BookId bookId = new BookId();
        bookId.setName(bookRequest.getName());
        bookId.setAuthor(bookRequest.getAuthor());
        if (bookRepository.existsById(bookId)) {
            throw new DataNotFoundException("Book already present");
        } else {
            final Book book = new Book();
            book.setGenre(bookRequest.getGenre());
            book.setPrice(bookRequest.getPrice());
            book.setId(bookId);

            final Book savedData = bookRepository.save(book);
            final BookDto response = BookDto.builder().
                    author(savedData.getId().getAuthor()).
                    name(savedData.getId().getName()).
                    genre(savedData.getGenre()).
                    price(savedData.getPrice()).
                    build();
            return ApiResponse.<BookDto>builder().data(response).build();
        }
    }
}
