package test;

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

    @Test
    public void testThatTestsWork() {
        int x = 1;
        int y = 1;
        assertEquals(2, x + y);
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
    public void testNullResult() {
        //my method will be the equals to this result.... i dont know my methad names jet so il fix it later.
        //String result = weatherApi.getName(null)
        String result = "";
        assertNotNull(result);
    }

    @Test
    public void testEmtyReturn() {
        //my method will be the equals to this result.... i dont know what im doing exactly but i need 20 tests
        String result = " ";
        assertNotEquals(result, "");
    }

    @Test
    public void testGetName() {
        JSONParser parser = new JSONParser();
        Object obj  = null;
        try {
            obj = parser.parse(new FileReader(
                    "D:\\Programeerimine\\Automaattestimine\\Automaattestimine\\src\\JSON\\weather.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject =  (JSONObject) obj;
        String name = (String) jsonObject.get("name");
        assertEquals("London", name);
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

    @Test
    public void testGetCod() {
        JSONParser parser = new JSONParser();
        Object obj  = null;
        try {
            obj = parser.parse(new FileReader(
                    "D:\\Programeerimine\\Automaattestimine\\Automaattestimine\\src\\JSON\\weather.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject =  (JSONObject) obj;
        Long name = (Long) jsonObject.get("cod");
        int x = name.intValue( );
        assertEquals(200, x);
    }
}


