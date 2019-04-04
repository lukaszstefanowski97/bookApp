package com.example.bookApp.rest;

import com.example.bookApp.config.Constants;
import com.example.bookApp.dto.Book;
import com.example.bookApp.dto.ResponseObject;
import com.example.bookApp.service.BookSaverService;
import com.example.bookApp.validation.InputValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@Slf4j
public class PostController {

    @Autowired
    private BookSaverService bookSaverService;

    @Autowired
    private InputValidation inputValidation;

    @RequestMapping(method = RequestMethod.POST, value = "/addBook")
    public ResponseObject addBook(@RequestBody Book book) {
        if (!inputValidation.validateAuthor(book.getAuthor()) && inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            ResponseObject responseObject =
                    new ResponseObject(400, "Bad Request", Constants.INVALID_AUTHOR_MESSAGE);

            return responseObject;

        } else if (inputValidation.validateAuthor(book.getAuthor()) && !inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            ResponseObject responseObject =
                    new ResponseObject(400, "Bad Request", Constants.INVALID_ISBN_MESSAGE);

            return responseObject;

        } else if (!inputValidation.validateAuthor(book.getAuthor()) && !inputValidation.validateIsbn(book.getIsbn())) {
            log.info(Constants.INVALID_ATTEMPT_MESSAGE);
            ResponseObject responseObject =
                    new ResponseObject(400, "Bad Request", Constants.INVALID_INPUT_MESSAGE);

            return responseObject;

        } else {
            log.info(Constants.REQUEST_ACCEPTED_MESSAGE.replace('.', ':') + "\n" +
                    book.getAuthor() + "\n" + book.getTitle() + "\n" + book.getIsbn());
            bookSaverService.saveToRepository(book.getAuthor(), book.getTitle(), book.getIsbn());
            ++Constants.entries;
            ResponseObject responseObject =
                    new ResponseObject(200, "OK", Constants.REQUEST_ACCEPTED_MESSAGE);

            return responseObject;
        }
    }
}
