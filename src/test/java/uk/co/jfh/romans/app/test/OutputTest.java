package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class OutputTest {

    @Test
    void testUserInput() throws IOException {
        // given
        String testString = "DCCCXLV";
        String expectedString = "DCCCXLV";
        ByteArrayOutputStream outputStream = null;
        String result = null;
        try {
            outputStream = new ByteArrayOutputStream();

            // when
            Romans.setOutputStream(outputStream);
            Romans.outputConvertedValue(testString);

            result = outputStream.toString(StandardCharsets.UTF_8);

        } finally {
            outputStream.close();
        }
        // then
        assertEquals(expectedString, result);
    }
}
