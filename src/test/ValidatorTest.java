package test;

import org.junit.jupiter.api.Test;
import reports.CordinateImp;
import reports.ForeCastImp;
import reports.Validator;

import static org.junit.Assert.assertEquals;

class ValidatorTest {
    @Test
    void validateGEO() {
        CordinateImp cordinates = new CordinateImp();
        Validator validator = new Validator();
        Boolean x = validator.validateGEO(cordinates.getCordinates());
        assertEquals(true, x);
    }

    @Test
    void validateTemp() {
        ForeCastImp forecast = new ForeCastImp();
        Validator validator = new Validator();
        boolean x = validator.validateTemp(forecast.getMaxTemp());
        assertEquals(true, x);
    }

}