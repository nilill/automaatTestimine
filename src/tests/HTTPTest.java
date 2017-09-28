package tests;

import net.aksingh.owmjapis.OpenWeatherMap;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class HTTPTest {
    public static String authCode;
    public static OpenWeatherMap.Units unit = OpenWeatherMap.Units.METRIC;
    public static String city = "Tallinn";
    private static OpenWeatherMap engine;


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
}


