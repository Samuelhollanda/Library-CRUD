package com.samuelholanda.CRUD_LIBRARY.infrastructure.repository;

import com.samuelholanda.CRUD_LIBRARY.infrastructure.entitys.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> getBookById(Integer id);

    @Transactional
    void deleteBookByName(String name);

}
