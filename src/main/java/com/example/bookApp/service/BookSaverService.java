package com.example.bookApp.service;

public interface BookSaverService {

    void saveToRepository(String author, String title, String isbn);
}
