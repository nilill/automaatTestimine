package implementations.controller;

import implementations.dataOperations.MockGetJsonObjectFromApi;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ControlerTest {

    private Controler controler;

    @Before
    public  void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();

        this.controler = new Controler(current, forecast, null);

        //GetJsonObjectFromApi currentWeatherGetter = Mockito.mock(GetJsonObjectFromApi.class);
        //whenNew(GetJsonObjectFromApi.class).withNoArguments().thenReturn(currentWeatherGetter);
        //when(currentWeatherGetter.getJsonObject()).thenReturn(new JSONObject("{\"dt\":1512568200,\"coord\":{\"lon\":24.75,\"lat\":59.44},\"visibility\":10000,\"weather\":[{\"icon\":\"04n\",\"description\":\"broken clouds\",\"main\":\"Clouds\",\"id\":803}],\"name\":\"Tallinn\",\"cod\":200,\"main\":{\"temp\":274.15,\"temp_min\":274.15,\"humidity\":74,\"pressure\":1005,\"temp_max\":274.15},\"clouds\":{\"all\":75},\"id\":588409,\"sys\":{\"country\":\"EE\",\"sunrise\":1512543699,\"sunset\":1512566564,\"id\":5014,\"type\":1,\"message\":0.0024},\"base\":\"stations\",\"wind\":{\"deg\":320,\"speed\":5.7}}"));
    }


    @Test
    public void setCity() {
        controler.setCity("Rakvere");
        assertEquals("Rakvere", controler.getCity());
    }

    @Test
    public void getDefaultCity() {
        assertEquals("Tallinn", controler.getCity());
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
    public void setCityFromFileThatDoesNotExist() {
        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\doesNotExist.txt");
        controler.setCityFromFile(path);
        assertEquals("Tartu", controler.getCity());

    }
}

