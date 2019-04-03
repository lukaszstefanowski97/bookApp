package com.example.bookApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Slf4j
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    Long id;

    @JsonProperty("author")
    String author;

    @JsonProperty("title")
    String title;

    @JsonProperty("isbn")
    String isbn;

    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }
}
