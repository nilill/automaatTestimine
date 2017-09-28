package tests;

import implementations.ForeCast;
import implementations.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ForeCastTest {
    private Validator validator = new Validator();
    @Test
    void getForecast() {
        ForeCast foreCast = new ForeCast("Tallinn");
        String fore = foreCast.getForecast();
        assertEquals(24, fore.length());
    }
    @Test
    void getMaxTemp() {
        ForeCast foreCast = new ForeCast("Tallinn");
        assertEquals(true, validator.validateTemp(foreCast.getMaxTemp()));
    }
    @Test
    void getMinTemp() {
        ForeCast foreCast = new ForeCast("Tallinn");
        assertEquals(true, validator.validateTemp(foreCast.getMinTemp()));
    }
}