package com.example.bookApp.service.impl;

import com.example.bookApp.dto.Book;
import com.example.bookApp.dto.BookRepository;
import com.example.bookApp.service.BookSaverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookSaverServiceImpl implements BookSaverService {

    BookRepository bookRepository;

    @Override
    public void saveToRepository(String author, String title, String isbn) {
        Book book = new Book(author, title, isbn);
        bookRepository.save(book);
    }
}
