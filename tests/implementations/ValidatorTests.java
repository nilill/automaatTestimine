package implementations;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorTests {
    private Validator validator = new Validator();

    @Test
    public void validateGeoCorrect() {
        assertEquals(false, validator.validateGEO("123:123"));
    }
    @Test
    public void validateGeoWithoutColon() {
        assertEquals(false, validator.validateGEO("123123"));
    }
    @Test
    public void validateTempCorrect() {
        assertEquals(false, validator.validateTemp(""));
    }
    @Test
    public void validateTempTooBig() {
        assertEquals(false, validator.validateTemp("a"));
    }
    @Test
    public void validateTempCorrectMetric() {
        assertEquals("Metric", validator.getMeasurmentSystem());
    }
}