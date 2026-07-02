package com.example.injection;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService {
    private final LibraryRepository repository;

    // Constructor injection
    public ConstructorInjectedService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addBook(String title) {
        repository.save(title);
    }

    public List<String> getBooks() {
        return repository.findAll();
    }
}
