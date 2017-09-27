package test;

import org.junit.jupiter.api.Test;
import reports.Controler;
import reports.CordinateImp;

import static org.junit.Assert.assertEquals;

class CordinateImpTest {
    @Test
    void getCordinates() {
        CordinateImp cordinates = new CordinateImp();
        String x = cordinates.getCordinates();
        int lenOfString = x.length();
        assertEquals(12, lenOfString);
    }

    @Test
    void getCity() {
        Controler controller = new Controler();
        controller.setCity("Tallinn");
        CordinateImp cordinateImp = new CordinateImp();
        String city = cordinateImp.getCity();
        assertEquals("Tallinn", city);
    }

}