package com.example.book;

import java.util.List;

public interface BookRepository {
    void save(String title);
    List<String> findAll();
}
