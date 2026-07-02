package com.example.injection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterInjectedService {
    private LibraryRepository repository;

    // Setter injection
    @Autowired
    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }

    public void addBook(String title) {
        repository.save(title);
    }

    public List<String> getBooks() {
        return repository.findAll();
    }
}
