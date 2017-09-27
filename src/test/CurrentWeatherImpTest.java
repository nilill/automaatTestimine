package test;

import org.junit.jupiter.api.Test;
import reports.Controler;
import reports.CurrentWeatherImp;

import static org.junit.Assert.assertEquals;

class CurrentWeatherImpTest {
    @Test
    void getCurrentWeather() {
        CurrentWeatherImp forecast = new CurrentWeatherImp();
        String x = forecast.getCurrentWeather();
        int lenOfString = x.length();
        assertEquals(12, lenOfString);
    }

    @Test
    void getCity() {
        Controler controller = new Controler();
        controller.setCity("Tallinn");
        CurrentWeatherImp currentWeatherImp = new CurrentWeatherImp();
        String city = currentWeatherImp.getCity();
        assertEquals("Tallinn", city);
    }

}