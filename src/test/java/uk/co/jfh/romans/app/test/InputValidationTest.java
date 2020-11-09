package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class InputValidationTest {

    @Test
    void testValidateNoInputFails() throws IOException {
        assertFalse(Romans.validateInput("\n"));
    }

    @Test
    void testValidateInvalidInputFails() throws IOException {
        assertFalse(Romans.validateInput("Abc\n"));
    }
}
