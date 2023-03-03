package com.school.management.student.service;

import com.school.management.common.exception.handler.DataNotFoundException;
import com.school.management.student.model.Book;
import com.school.management.student.model.BookId;
import com.school.management.student.repository.BookRepository;
import com.school.management.student.request.BookRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private BookRequest bookRequest;
    private BookId bookId;

    @BeforeEach
    void setUp() {
        bookRequest = new BookRequest();
        bookRequest.setName("Test Book Name");
        bookRequest.setAuthor("Test Author");
        bookRequest.setGenre("Sci-Fi");
        bookRequest.setPrice(100);
        bookId = new BookId();
        bookId.setName(bookRequest.getName());
        bookId.setAuthor(bookRequest.getAuthor());
    }

    @Test
    void test_book_already_present_in_the_library() {
        given(bookRepository.existsById(bookId)).willReturn(true);
        assertThrows(DataNotFoundException.class, () -> bookService.saveBook(bookRequest));
    }

    @Test
    void test_register_book() {
        given(bookRepository.existsById(bookId)).willReturn(false);
        final Book book = new Book();
        book.setId(bookId);
        book.setGenre(bookRequest.getGenre());
        book.setPrice(bookRequest.getPrice());
        given(bookRepository.save(book)).willReturn(book);
        assertEquals("Test Book Name", bookService.saveBook(bookRequest).getData().getName());
    }

    @AfterEach
    void tearDown() {
        bookId = null;
        bookRequest = null;
    }
}