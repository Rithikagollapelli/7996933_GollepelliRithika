package com.example.injection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryLibraryRepository implements LibraryRepository {
    private final List<String> books = new ArrayList<>();

    @Override
    public void save(String book) {
        books.add(book);
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(books);
    }
}
