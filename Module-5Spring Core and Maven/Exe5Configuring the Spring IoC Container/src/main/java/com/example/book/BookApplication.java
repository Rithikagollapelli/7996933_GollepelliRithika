package com.example.book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            BookService bookService = context.getBean(BookService.class);
            bookService.addBook("Effective Java");
            bookService.addBook("Head First Design Patterns");

            System.out.println("Books in library:");
            bookService.getBooks().forEach(System.out::println);
        }
    }
}
