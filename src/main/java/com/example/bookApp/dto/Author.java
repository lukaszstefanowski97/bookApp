package com.example.bookApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @JsonProperty("author")
    String author;

    public Author(String author) {
        this.author = author;
    }
}
