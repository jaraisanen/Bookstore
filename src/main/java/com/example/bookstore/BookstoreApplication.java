package com.example.bookstore;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;
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
    public CommandLineRunner studentDemo(BookRepository brepository, UserRepository urepository) {
        return (args) -> {
            log.info("Inserting dummy data");
            brepository.save(new Book("Harry Potter", "J.K.Rowling", "2014", "12345-21", "12,23"));
            brepository.save(new Book("Da Vinci Code", "Robert Langdon", "2001", "1232-23", "11,23"));

            User user1 = new User("user",
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin",
                    "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);

            log.info("Showing all students");
            for (Book book : brepository.findAll()) {
                log.info(book.toString());
            }

        };
    }
}
