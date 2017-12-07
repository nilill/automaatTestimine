package implementations.reports;

import implementations.controller.Controler;
import implementations.dataOperations.GetJsonObjectFromApi;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoordinatesTest {
    
    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

    private Controler controler;

    @Before
    public void setup() {
        GetJsonObjectFromApi current = mock(GetJsonObjectFromApi.class);
        GetJsonObjectFromApi forecast = mock(GetJsonObjectFromApi.class);
        when((forecast).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getForecastWeatherJson());
        when((current).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getCurrentWeatherJson());
        this.controler = new Controler(current.getJsonObject(), forecast.getJsonObject(), writeToFile);
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
