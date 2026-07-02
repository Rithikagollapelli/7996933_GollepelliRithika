package com.example.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LibraryApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            LibraryService libraryService = context.getBean(LibraryService.class);
            libraryService.addBook("The Hobbit");
            libraryService.addBook("1984");

            System.out.println("Books in library:");
            libraryService.getBooks().forEach(System.out::println);
        }
    }
}
