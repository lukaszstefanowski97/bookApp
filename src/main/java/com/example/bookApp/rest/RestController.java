package com.example.bookApp.rest;

import com.example.bookApp.config.Constants;
import com.example.bookApp.dto.*;
import com.example.bookApp.service.BookGetterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@AllArgsConstructor
public class RestController {

    @Autowired
    BookGetterService bookGetterService;

    @RequestMapping("/hello")
    public String sayHello() {
        return Constants.entries == 0 ? Constants.HELLO_MESSAGE_NO_RECORDS : Constants.HELLO_MESSAGE;
    }

    @RequestMapping("/books")
    public <T> T getAllBooks() {
        if (Constants.entries == 0) {
            ResponseObject responseObject =
                    new ResponseObject(204, "No content", Constants.NO_CONTENT_MESSAGE);

            return (T) responseObject;
        }
        return (T) bookGetterService.getAllBooks();
    }

    @RequestMapping("/books/authors")
    public <T> T getAuthors() {
        if (Constants.entries == 0) {
            ResponseObject responseObject =
                    new ResponseObject(204, "No content", Constants.NO_CONTENT_MESSAGE);

            return (T) responseObject;
        }
        List<Book> books = bookGetterService.getAllBooks();
        List<Author> authors = new ArrayList<>();
        for (Book book: books) {
            authors.add(new Author(book.getAuthor()));
        }
        return (T) authors;
    }

    @RequestMapping("/books/titles")
    public <T> T getTitles() {
        if (Constants.entries == 0) {
            ResponseObject responseObject =
                    new ResponseObject(204, "No content", Constants.NO_CONTENT_MESSAGE);

            return (T) responseObject;
        }
        List<Book> books = bookGetterService.getAllBooks();
        List<Title> titles = new ArrayList<>();
        for (Book book: books) {
            titles.add(new Title(book.getTitle()));
        }
        return (T) titles;
    }

    @RequestMapping("/books/isbn")
    public <T> T getIsbn() {
        if (Constants.entries == 0) {
            ResponseObject responseObject =
                    new ResponseObject(204, "No content", Constants.NO_CONTENT_MESSAGE);

            return (T) responseObject;
        }
        List<Book> books = bookGetterService.getAllBooks();
        List<Isbn> isbns = new ArrayList<>();
        for (Book book: books) {
            isbns.add(new Isbn(book.getIsbn()));
        }
        return (T) isbns;
    }
}
