package implementations.reports;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTest {

    @Test
    public void validateGeoCorrect() {
        assertEquals(true, Validator.validateGEO(25.25));
    }

    @Test
    public void validateGeoWithoutColon() {
        assertEquals(false, Validator.validateGEO(-1));
    }

    @Test
    public void validateTempCorrect() {
        assertEquals(true, Validator.validateTemp("25"));
    }

    @Test
    public void validateTempTooBig() {
        assertEquals(false, Validator.validateTemp("150"));
    }

    @Test
    public void validateTempConstainsLetters() {
        assertEquals(false, Validator.validateTemp("aaa"));
    }
}