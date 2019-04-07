package com.example.bookApp.rest;

import com.example.bookApp.config.Constants;
import com.example.bookApp.dto.Book;
import com.example.bookApp.service.BookGetterService;
import com.example.bookApp.service.BookSaverService;
import com.example.bookApp.validation.InputValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class WebRestController {

    @Autowired
    public BookSaverService bookSaverService;

    @Autowired
    private InputValidation inputValidation;

    @Autowired
    public BookGetterService bookGetterService;

    @RequestMapping("/")
    public String getAllBooks(Model model) {
        model.addAttribute("helloMessage", Constants.HELLO_MESSAGE);
        model.addAttribute("noContent", Constants.NO_CONTENT_MESSAGE);
        model.addAttribute("books", bookGetterService.getAllBooks());
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("/addbook")
    public String addUser(Book book, Model model) {
        model.addAttribute("helloMessage", Constants.HELLO_MESSAGE);
        model.addAttribute("noContent", Constants.NO_CONTENT_MESSAGE);

        if (!inputValidation.validateAuthor(book.getAuthor()) && inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            model.addAttribute("message", Constants.INVALID_AUTHOR_MESSAGE);
            model.addAttribute("books", bookGetterService.getAllBooks());
            return "books";
        } else if (inputValidation.validateAuthor(book.getAuthor()) && !inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            model.addAttribute("message", Constants.INVALID_ISBN_MESSAGE);
            model.addAttribute("books", bookGetterService.getAllBooks());
            return "books";
        } else if (!inputValidation.validateAuthor(book.getAuthor()) && !inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            model.addAttribute("message1", Constants.INVALID_AUTHOR_MESSAGE);
            model.addAttribute("message2", Constants.INVALID_ISBN_MESSAGE);
            model.addAttribute("books", bookGetterService.getAllBooks());
            return "books";
        } else {
            log.info(Constants.REQUEST_ACCEPTED_MESSAGE.replace('.', ':') + "\n" +
                    book.getAuthor() + "\n" + book.getTitle() + "\n" + book.getIsbn());
            bookSaverService.saveToRepository(book.getAuthor(), book.getTitle(), book.getIsbn());
            model.addAttribute("books", bookGetterService.getAllBooks());
            return "books";
        }
    }
}
