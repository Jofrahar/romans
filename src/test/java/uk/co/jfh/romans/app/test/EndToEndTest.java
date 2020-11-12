package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class EndToEndTest {

    @Test
    void testEndtoEndValidSingleCase() throws IOException {
        // given
        String testString = "100\n";
        String expectedResult = "C";
        String result;
        try (InputStream inputStream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // when
            Romans.setInputStream(inputStream);
            Romans.setOutputStream(outputStream);
            Romans.main(null);
            result = outputStream.toString(StandardCharsets.UTF_8);
        }
        // then
        assertEquals(expectedResult, result);
    }

    @Test
    void testEndtoEndInvalidSingleCase() throws IOException {
        // given
        String testString = "12345\n";
        String expectedResult = "Invalid input";
        String result;
        try (InputStream inputStream = new ByteArrayInputStream(testString.getBytes(StandardCharsets.UTF_8));
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // when
            Romans.setInputStream(inputStream);
            Romans.setOutputStream(outputStream);
            Romans.main(null);
            result = outputStream.toString(StandardCharsets.UTF_8);
        }
        // then
        assertEquals(expectedResult, result);
    }
}
