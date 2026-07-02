package com.example.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class LibraryApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            LibraryService libraryService = context.getBean(LibraryService.class);
            libraryService.addBook("Refactoring");
            libraryService.addBook("Domain-Driven Design");

            System.out.println("Books in library:");
            libraryService.getBooks().forEach(System.out::println);
        }
    }
}
