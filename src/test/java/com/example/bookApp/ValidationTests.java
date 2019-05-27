package com.example.bookApp;

import com.example.bookApp.validation.InputValidation;
import com.example.bookApp.validation.impl.InputValidationImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ValidationTests {

    @Test
    public void nameShouldBeValid() {
        InputValidation validation = new InputValidationImpl();

        boolean result1 = validation.validateAuthor("Adam Adam");
        boolean result2 = validation.validateAuthor("Adam Smith");
        boolean result3 = validation.validateAuthor("Adam");
        boolean result4 = validation.validateAuthor("A23");
        boolean result5 = validation.validateAuthor(null);

        assertNotNull(result1);
        assertEquals(true, result1);

        assertNotNull(result2);
        assertEquals(false, result2);

        assertNotNull(result3);
        assertEquals(true, result3);

        assertNotNull(result4);
        assertEquals(false, result4);

        assertNotNull(result5);
        assertEquals(false, result5);
    }
}
