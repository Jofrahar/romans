package uk.co.jfh.romans.app.test;

import org.junit.jupiter.api.Test;

import uk.co.jfh.romans.app.Romans;

public class UserInputTest {

    @Test
    void testEndtoEndSingleCase() {
        // given

        // when
        Romans.main(null);
        // then

        // no exceptions
    }

    @Test
    void testUserInput() {
        // given
        Romans romans = new Romans();
        // romans.main(null);
    }

}
