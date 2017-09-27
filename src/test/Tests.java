package test;

import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.*;

public class    Tests {
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
    @Test
    public void testGetId() {
        JSONParser parser = new JSONParser();
        Object obj  = null;
        try {
            obj = parser.parse(new FileReader(
                    "D:\\Programeerimine\\Automaattestimine\\Automaattestimine\\src\\JSON\\weather.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject =  (JSONObject) obj;
        Long name = (Long) jsonObject.get("id");
        int x = name.intValue( );
        assertEquals(2643743, x);
    }
}


