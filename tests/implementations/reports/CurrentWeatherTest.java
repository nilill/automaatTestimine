package implementations.reports;

import implementations.controller.Controler;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CurrentWeatherTest {
    private Controler controler;

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

    @Before
    public void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, writeToFile);
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
