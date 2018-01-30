package com.example.bookstore.web;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.ManyToOne;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    @ManyToOne
    @JsonIgnore
    private BookRepository repository;


    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping("/addbook")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
        repository.delete(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    // Rest Api provider methods

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findOne(bookId);
    }

    // Adding new Book through curl
    // curl -i -X POST -H "Content-Type:application/json" -d "{ \"title\" : \"Da Vinci Code\", \"author\" :
    // \"Robert Langdon\", \"year\" : \"2001\", \"isbn\" : \"1232-23\", \"price\" : \"11,23\" }" http://localhost:8080/api/books

    // Searching
    // curl http://localhost:8080/api/books/search/findByTitle?title=Harry+Potter


}




