package com.example.book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final List<String> books = new ArrayList<>();

    @Override
    public void save(String title) {
        books.add(title);
    }

    @Override
    public List<String> findAll() {
        return new ArrayList<>(books);
    }
}
