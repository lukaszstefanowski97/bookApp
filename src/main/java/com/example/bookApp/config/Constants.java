package com.example.bookApp.config;

public class Constants {

    public static final String INVALID_AUTHOR_MESSAGE = "Invalid author input. Forename and surename should start " +
            "with 'A'.";
    public static final String INVALID_ISBN_MESSAGE = "ISBN number should be given as string with length of 13 " +
            "digits and it should be integer.";
    public static final String INVALID_INPUT_MESSAGE = INVALID_AUTHOR_MESSAGE + " " + INVALID_ISBN_MESSAGE;
}
