package uk.co.jfh.romans.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class ConversionTest {

    @Test
    void testConversions() throws IOException {
        assertEquals("I", Romans.convertInput("1"));
        assertEquals("III", Romans.convertInput("3"));
        assertEquals("XIII", Romans.convertInput("13"));
        assertEquals("CCLVI", Romans.convertInput("256"));
        assertEquals("DCCCXCIX", Romans.convertInput("899"));
        assertEquals("ML", Romans.convertInput("1050"));
        assertEquals("MMMCMXCIX", Romans.convertInput("3999"));
        assertEquals("XIV", Romans.convertInput("14"));
        assertEquals("LXXIX", Romans.convertInput("79"));
        assertEquals("CCXXV", Romans.convertInput("225"));
        assertEquals("DCCCXLV", Romans.convertInput("845"));
        assertEquals("MMXXII", Romans.convertInput("2022"));

    }

}
