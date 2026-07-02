package com.example.library;

import java.util.List;

public interface LibraryRepository {
    void save(String book);
    List<String> findAll();
}
