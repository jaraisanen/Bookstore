package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
/* If using Thymeleaf, delete ResponseBody annotation*/
@ResponseBody
public class BookController {
    @RequestMapping("/")
    public String index() {
        return "This is the main page";
    }

}