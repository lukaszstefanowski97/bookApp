package com.example.bookApp.rest;

import com.example.bookApp.dto.Book;
import com.example.bookApp.service.BookGetterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@AllArgsConstructor
public class RestController {

    @Autowired
    BookGetterService bookGetterService;

    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookGetterService.getAllBooks();
    }
}
