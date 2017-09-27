package test;

import org.junit.jupiter.api.Test;
import reports.ForeCastImp;
import reports.Validator;

import static org.junit.Assert.assertEquals;

class ForeCastImpTest {
    @Test
    void getForecast() {
        ForeCastImp forecast = new ForeCastImp();
        String x = forecast.getForecast();
        int lenOfString = x.length();
        assertEquals(8, lenOfString);
    }

    @Test
    void getMaxTemp() {
        ForeCastImp forecast = new ForeCastImp();
        Validator validator = new Validator();
        boolean x = validator.validateTemp(forecast.getMaxTemp());
        assertEquals(true, x);
    }

    @Test
    void getMinTemp() {
        ForeCastImp forecast = new ForeCastImp();
        Validator validator = new Validator();
        boolean x = validator.validateTemp(forecast.getMinTemp());
        assertEquals(true, x);
    }

}