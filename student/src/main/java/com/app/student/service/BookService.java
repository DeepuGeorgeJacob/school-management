package com.app.student.service;

import com.app.student.dto.BookDto;
import com.common.exception.handler.DataNotFoundException;
import com.common.response.ApiResponse;
import com.app.student.model.Book;
import com.app.student.model.BookId;
import com.app.student.repository.BookRepository;
import com.app.student.request.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

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
