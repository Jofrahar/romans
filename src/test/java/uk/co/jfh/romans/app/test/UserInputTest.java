package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class UserInputTest {

    @Test
    void testEndtoEndSingleCase() throws IOException {
        // given
        String testString = "100\n";
        try (InputStream inputStream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8))) {
            // when
            Romans.setInputStream(inputStream);
            Romans.main(null);
        }
        // then

        // no exceptions
    }

    @Test
    void testUserInput() throws IOException {
        // given
        String testString = "100\n";
        String expectedString = "100";
        InputStream inputStream = null;
        String result = null;
        try {
            inputStream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));

            // when
            Romans.setInputStream(inputStream);
            result = Romans.getUserInput();

        } finally {
            inputStream.close();
        }
        // then
        assertEquals(expectedString, result);
    }

    @Test
    void testValidateNoInputFails() throws IOException {
        assertFalse(Romans.validateInput("\n"));
    }

    @Test
    void testValidateInvalidInputFails() throws IOException {
        assertFalse(Romans.validateInput("Abc\n"));
    }
}
