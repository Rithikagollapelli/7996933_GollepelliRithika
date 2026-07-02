package com.example.book;

import java.util.List;

public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(String title) {
        repository.save(title);
    }

    public List<String> getBooks() {
        return repository.findAll();
    }
}
