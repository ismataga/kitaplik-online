package com.example.bookservice;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {
    private final BookRepository repository;

    public BookServiceApplication(BookRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Dunyanin guzu", "",2000,"", "Robrt Jordan", "Altin");
        Book book2 = new Book("cagri", "",2020, "","Elcin Jordan", "Altin");
        Book book3 = new Book("Xalq", "",2000,"", "Gilbert Jordan", "Altin");

        List<Book> bookList = repository.saveAll(Arrays.asList(book1, book2, book3));
        System.out.println(bookList);

    }
}
