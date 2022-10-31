package com.school.management.student.repository;

import com.school.management.student.model.Book;
import com.school.management.student.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, BookId> {
}
