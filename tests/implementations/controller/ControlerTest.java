package implementations.controller;

import implementations.dataOperations.GetJsonObjectFromApi;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ControlerTest {

    private Controler controler;

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

    @Before
    public  void setup() {
        GetJsonObjectFromApi current =  mock(GetJsonObjectFromApi.class);
        GetJsonObjectFromApi forecast = mock(GetJsonObjectFromApi.class);
        when((current).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getCurrentWeatherJson());
        when((forecast).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getForecastWeatherJson());
        this.controler = new Controler(current.getJsonObject(), forecast.getJsonObject(), writeToFile);
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

