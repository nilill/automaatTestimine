package implementations.reports;

import implementations.controller.Controler;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {


    private Controler controler;

    @Before
    public void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, null);
    }

    @Test
    public void getCoordinates() {
        assertEquals("Coordinates: 24.75/59.44", controler.getCoordinates());
    }

    @Test
    public void getCurrentWeatherCorrectStringLenght() {
        String forecast = controler.getForecastWeather();
        boolean correctFormat = forecast.matches(".*\\d.*") && forecast.contains(".");
        assertEquals(true, correctFormat);
    }

    @Test
    public void getForecastWeatherCorrectStringLenght() {
        controler.setCity("Tallinn");
        int weatherLenght = controler.getForecastWeather().length();
        assertEquals(54, weatherLenght);
    }

    @Test
    public void getCurrentWeather() throws Exception {
        String currentWeather = controler.getCurrentWeather();
        assertEquals("1.0°", currentWeather);
    }

    @Test
    public void setCityFromFile() {

        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\input.txt");
        controler.setCityFromFile(path);
        assertEquals("Tartu", controler.getCity());
    }


    @Test
    public void setCityFromFileThatDoesNotExist() {
        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\doesNotExist.txt");
        controler.setCityFromFile(path);
        assertEquals("Tartu", controler.getCity());

    }
}
