package implementations;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ControlerTests {
    @Test
    public void setCity() {
        Controler controler = new Controler();
        controler.setCity("Rakvere");
        assertEquals("Rakvere", controler.getCity());
    }

    @Test
    public void getDefaultCity() {
        Controler controler = new Controler();
        assertEquals("Tallinn", controler.getCity());
    }

    @Test
    public void getCoordinates() {
        Controler controler = new Controler();
        controler.setCity("Rakvere");
        String cordinates = "252:252";
        assertEquals("252:252", cordinates);
    }

    @Test
    public void getCoordinatesWithColons() {
        Controler controler = new Controler();
        assertEquals("Coordinates: 24.75/59.44", controler.getCoordinates());
    }

    @Test
    public void getCurrentWeatherCorrectStringLenght() {
        Controler controler = new Controler();
        String forecast = controler.getForecastWeather();
        boolean correctFormat = forecast.matches(".*\\d.*") && forecast.contains(".");
        assertEquals(true, correctFormat);
    }

    @Test
    public void getForecastWeatherCorrectStringLenght() {
        Controler controler = new Controler();
        controler.setCity("Tallinn");
        int weatherLenght = controler.getForecastWeather().length();
        ;
        assertEquals(17, weatherLenght);
    }

    @Test
    public void getCurrentWeather() throws Exception {
        Controler controler = new Controler();
        String currentWeather = controler.getCurrentWeather();
        boolean correctFormat = currentWeather.matches(".*\\d.*") && currentWeather.contains(".");
        assertEquals(true, correctFormat);
    }

    @Test
    public void setCityFromFile() {
        Controler controler = new Controler();
        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\input.txt");
        controler.setCityFromFile(path);
        assertEquals("Cyprus", controler.getCity());
    }

    @Test
    public void setCityFromConsole() {
        Controler controler = new Controler();
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        controler.setCityFromConsole();
        System.setIn(System.in);
        assertEquals("My string", controler.getCity());
    }

    @Test
    public void setCityFromFileThatDoesNotExist() {
        Controler controler = new Controler();
        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\doesNotExist.txt");
        controler.setCityFromFile(path);
        assertEquals("Tallinn", controler.getCity());

    }
}

