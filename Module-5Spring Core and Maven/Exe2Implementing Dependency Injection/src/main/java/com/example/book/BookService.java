package com.example.book;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("BookService: adding book -> " + title);
        bookRepository.addBook(title);
    }

    public List<String> getBooks() {
        System.out.println("BookService: fetching all books");
        return bookRepository.getBooks();
    }
}
