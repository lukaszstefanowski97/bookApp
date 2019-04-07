package com.example.bookApp.config;

public class Constants {

    public static int entries = 0;

    public static final String INVALID_AUTHOR_MESSAGE = "Invalid author input. Forename and surename should both " +
            "start with 'A'.";

    public static final String INVALID_ISBN_MESSAGE = "Invalid ISBN input. ISBN number should be given as string with" +
            " length of 13 " +
            "digits and it should be integer.";
    public static final String INVALID_INPUT_MESSAGE = INVALID_AUTHOR_MESSAGE + " \n" + INVALID_ISBN_MESSAGE;

    public static final String REQUEST_ACCEPTED_MESSAGE = "Posted new item to book repository.";

    public static final String INVALID_ATTEMPT_MESSAGE = "Attempt to save item with invalid input";

    public static final String NO_CONTENT_MESSAGE = "NO RECORDS";

    public static final String HELLO_MESSAGE = "Welcome to bookApp!";
}
