package com.example.book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final List<String> books = new ArrayList<>();

    @Override
    public void addBook(String title) {
        books.add(title);
    }

    @Override
    public List<String> getBooks() {
        return new ArrayList<>(books);
    }
}
