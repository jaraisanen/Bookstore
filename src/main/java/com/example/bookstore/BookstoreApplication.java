package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
	    SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
    public CommandLineRunner studentDemo(BookRepository repository) {
        return (args) -> {
            log.info("Inserting dummy data");
            repository.save(new Book("Harry Potter", "J.K.Rowling", "2014", "12345-21", "12,23"));
            repository.save(new Book("Da Vinci Code", "Robert Langdon", "2001", "1232-23", "11,23"));

            log.info("Showing all students");
            for (Book book : repository.findAll()) {
                log.info(book.toString());
            }

        };
    }
}
