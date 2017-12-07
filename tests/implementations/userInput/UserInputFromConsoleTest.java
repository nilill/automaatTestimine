package implementations.userInput;

import implementations.controller.Controler;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class UserInputFromConsoleTest {
    private Controler controler;

    @Before
    public  void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, null);
    }

    @Test
    public void setCityFromConsole() {
        ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
        System.setIn(in);
        controler.setCityFromConsole();
        System.setIn(System.in);
        assertEquals("My string", controler.getCity());
    }

}