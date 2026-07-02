package com.example.book;

import java.util.List;

public interface BookRepository {
    void addBook(String title);
    List<String> getBooks();
}
