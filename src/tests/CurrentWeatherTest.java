package tests;

import implementations.CurrentWeather;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CurrentWeatherTest {
    @Test
    void getCurrentWeatherStringLenght() {
        CurrentWeather currentWeather = new CurrentWeather("Tallinn");
        String weather = currentWeather.getCurrentWeather();
        assertEquals(12, weather.length());
    }
}