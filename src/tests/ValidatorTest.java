package tests;

import implementations.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ValidatorTest {
    private Validator validator = new Validator();

    @Test
    void validateGeoCorrect() {
        assertEquals(true, validator.validateGEO("123:123"));
    }
    @Test
    void validateGeoWithoutColon() {
        assertEquals(false, validator.validateGEO("123123"));
    }
    @Test
    void validateTempCorrect() {
        assertEquals(false, validator.validateTemp(30));
    }
    @Test
    void validateTempTooBig() {
        assertEquals(false, validator.validateTemp(1231));
    }
    @Test
    void validateTempCorrectMetric() {
        assertEquals("Metric", validator.getMeasurmentSystem());
    }
}