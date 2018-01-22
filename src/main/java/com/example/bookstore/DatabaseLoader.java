package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner{

    private final Logger logger = LoggerFactory.getLogger(DatabaseLoader.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Loading data...");


    }
}
