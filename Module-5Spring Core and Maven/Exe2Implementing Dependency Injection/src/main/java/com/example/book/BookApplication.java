package com.example.book;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            BookService bookService = context.getBean("bookService", BookService.class);
            bookService.addBook("Spring in Action");
            bookService.addBook("Pro Spring Boot");

            System.out.println("Books in library:");
            bookService.getBooks().forEach(System.out::println);
        }
    }
}
