package tests;

import implementations.Controler;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ControlerTest {

    @Test
    void getCity() {
        Controler controler =  new Controler();
        controler.setCity("Tallinn");
        assertEquals("Tallinn", controler.getCity());
    }
    @Test
    void getCoordinates() {
        Controler controler =  new Controler();
        controler.setCity("Rakvere");
        String cordinates = "252:252";
        assertEquals("Rakvere", cordinates);
    }
    @Test
    void getCoordinatesWithColons() {
        Controler controler =  new Controler();
        controler.setCity("Tallinn");
        String cordinates = "252:252";;
        assertEquals("Tallinn", cordinates);
    }
    @Test
    void getCurrentWeatherCorrectStringLenght() {
        Controler controler =  new Controler();
        controler.setCity("Tallinn");
        int weatherLenght = controler.getCurrentWeather().length();;
        assertEquals(12, weatherLenght);
    }
    @Test
    void getForecastWeatherCorrectStringLenght() {
        Controler controler =  new Controler();
        controler.setCity("Tallinn");
        int weatherLenght = controler.getForecastWeather().length();;
        assertEquals(20, weatherLenght);
    }
}