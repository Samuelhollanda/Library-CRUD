package com.samuelholanda.CRUD_LIBRARY.business;

import com.samuelholanda.CRUD_LIBRARY.infrastructure.entitys.Book;
import com.samuelholanda.CRUD_LIBRARY.infrastructure.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void saveBook(Book book) {
        repository.saveAndFlush(book);
    }

    public Book getBookById(Integer id) {
        return repository.getBookById(id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );
    }

    public void deleteBookById(Integer id) {
        repository.deleteBookById(id);
    }

    public void updateBookById(Integer id, Book book) {
        Book bookEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Book not found")
        );
        Book updateBook = Book.builder()
                .author(book.getAuthor() != null ?
                        book.getAuthor() : bookEntity.getAuthor())
                .publisher(book.getPublisher() != null ?
                        book.getPublisher() : bookEntity.getPublisher())
                .id(bookEntity.getId())
                .build();

        repository.saveAndFlush(updateBook);
    }
}
