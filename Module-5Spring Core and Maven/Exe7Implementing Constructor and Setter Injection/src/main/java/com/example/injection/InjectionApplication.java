package com.example.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectionApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ConstructorInjectedService cis = context.getBean(ConstructorInjectedService.class);
            SetterInjectedService sis = context.getBean(SetterInjectedService.class);

            cis.addBook("Constructor Book");
            sis.addBook("Setter Book");

            System.out.println("Constructor service books:");
            cis.getBooks().forEach(System.out::println);

            System.out.println("Setter service books:");
            sis.getBooks().forEach(System.out::println);
        }
    }
}
