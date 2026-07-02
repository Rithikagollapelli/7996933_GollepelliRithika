package com.example.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryBootApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository repo) {
        return args -> {
            repo.save(new Book("Spring in Action"));
            repo.save(new Book("Pro Spring Boot"));
        };
    }
}
