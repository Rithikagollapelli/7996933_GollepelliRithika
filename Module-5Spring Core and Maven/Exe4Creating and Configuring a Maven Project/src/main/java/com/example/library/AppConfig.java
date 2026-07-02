package com.example.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public LibraryRepository libraryRepository() {
        return new InMemoryLibraryRepository();
    }

    @Bean
    public LibraryService libraryService(LibraryRepository libraryRepository) {
        return new LibraryService(libraryRepository);
    }
}
