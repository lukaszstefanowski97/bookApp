package com.example.bookApp.validation.impl;

import com.example.bookApp.validation.InputValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InputValidationImpl implements InputValidation {

    @Override
    public Boolean validateAuthor(String author) {
        int secondNameIndex = 0;
        for (int i = 0; i < author.length(); i++) {
            if (author.charAt(i) == ' ') secondNameIndex = i + 1;
        }
        return author.startsWith("A") && author.charAt(secondNameIndex) == 'A';
    }

    @Override
    public Boolean validateIsbn(String isbn) {
        try {
            if (isbn.length() != 13) return false;
            Long value = Long.valueOf(isbn);
            return true;
        } catch (Exception type) {
            return false;
        }
    }
}
