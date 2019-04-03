package com.example.bookApp.rest;

import com.example.bookApp.config.Constants;
import com.example.bookApp.service.BookGetterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.core.Response;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@AllArgsConstructor
public class RestController {

    @Autowired
    BookGetterService bookGetterService;

    @RequestMapping("/books")
    public <T> T getAllBooks() {
        if (Constants.entries == 0) return (T) Response.status(Response.Status.NO_CONTENT)
                .entity(Constants.NO_CONTENT_MESSAGE).build();
        return (T) bookGetterService.getAllBooks();
    }
}
