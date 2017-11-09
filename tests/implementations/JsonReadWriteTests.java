package implementations;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class JsonReadWriteTests {
    public static String authCode;
    public static String city = "Tallinn";

    @Test(expected = IllegalArgumentException.class)
    public void tryFalseUrl() {
        JsonReadWrite jsonReadWrite = new JsonReadWrite("ei url");
    }

    @Test
    public void getStringType() {
        JsonReadWrite jsonReadWrite = new JsonReadWrite("http://api.openweathermap.org/data/" +
                "2.5/weather?q=Tallinn&appid=bb9800b5d5cb9957043c1c7764bbf1c0");
        assertEquals("Tallinn", jsonReadWrite.getStringDepthOne("name"));
    }

    @Test
    public void getStringTypeInJsonObject() {
        JsonReadWrite jsonReadWrite = new JsonReadWrite("http://api.openweathermap.org/data/" +
                "2.5/weather?q=Tallinn&appid=bb9800b5d5cb9957043c1c7764bbf1c0");
        assertEquals("EE", jsonReadWrite.getStringDepthTwo("sys", "country"));
    }


    @Test
    public void testHttpConnection() throws java.io.IOException {
        String strUrl = "https://openweathermap.org/";

        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();
            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testWriteToFile() {
        Controler controler = new Controler();
        String currentWeather = controler.getCurrentWeather();
        String forecast = controler.getForecastWeather();
        String coordinates = controler.getCoordinates();
        JsonReadWrite.writeToFile(currentWeather + "\n" + forecast + "\n" + coordinates);
        Path path = Paths.get("D:\\Programeerimine\\Automaattestimine\\automaatTestimine", "info.txt");
        int counter = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while(reader.readLine() != null) {
                counter++;
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
        assertEquals(3, counter);

    }
}


