package com.example.bookApp.service.impl;

import com.example.bookApp.dto.Book;
import com.example.bookApp.dto.BookRepository;
import com.example.bookApp.service.BookGetterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookGetterServiceImpl implements BookGetterService {

    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
