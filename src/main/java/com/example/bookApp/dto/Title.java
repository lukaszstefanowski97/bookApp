package com.example.bookApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Title {

    @JsonProperty("title")
    String title;

    public Title(String title) {
        this.title = title;
    }
}
