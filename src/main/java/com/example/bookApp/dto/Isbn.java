package com.example.bookApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Isbn {

    @JsonProperty("isbn")
    String isbn;

    public Isbn(String isbn) {
        this.isbn = isbn;
    }
}
