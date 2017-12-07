package implementations.reports;

import implementations.controller.Controler;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentWeatherTest {
    private Controler controler;

    @Before
    public void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, null);
    }

    @Test
    public void getCurrentWeatherCorrectStringLenght() {
        String forecast = controler.getForecastWeather();
        boolean correctFormat = forecast.matches(".*\\d.*") && forecast.contains(".");
        assertEquals(true, correctFormat);
    }

    @Test
    public void getCurrentWeather() throws Exception {
        String currentWeather = controler.getCurrentWeather();
        assertEquals("1.0°", currentWeather);
    }

}
