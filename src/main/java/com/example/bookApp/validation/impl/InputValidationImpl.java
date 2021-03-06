package com.example.bookApp.validation.impl;

import com.example.bookApp.validation.InputValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InputValidationImpl implements InputValidation {

    @Override
    public Boolean validateAuthor(String author) {
        if (author == null) return false;

        int secondNameIndex = 0;
        for (int i = 0; i < author.length() - 1; i++) {
            if (author.charAt(i) == ' ') {
                secondNameIndex = i + 1;
            } else {
                if (!Character.isLetter(author.charAt(i))) return false;
            }
        }
        return author.startsWith("A") && author.charAt(secondNameIndex) == 'A';
    }

    @Override
    public Boolean validateIsbn(String isbn) {
        if (isbn == null) return false;

        try {
            if (isbn.length() != 13) return false;
            Long value = Long.valueOf(isbn);
            return true;
        } catch (Exception type) {
            return false;
        }
    }
}
