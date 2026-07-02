package com.example.library;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addBook(String title) {
        repository.save(title);
    }

    public List<String> getBooks() {
        return repository.findAll();
    }
}
