package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class InputValidationTest {

    @Test
    void testNoInputFails() throws IOException {
        assertFalse(Romans.validateInput("\n"));
    }

    @Test
    void testNonNumericInputFails() throws IOException {
        assertFalse(Romans.validateInput("Abc\n"));
    }

    @Test
    void testOutoOfRangeInputFails() throws IOException {
        assertFalse(Romans.validateInput("12345"));
    }
}
