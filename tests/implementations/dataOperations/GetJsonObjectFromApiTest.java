package implementations.dataOperations;


import implementations.controller.Controler;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetJsonObjectFromApiTest {


    private Controler controler;

    @Before
    public void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, null);
    }

    @Test
    public void getJsonObject() throws Exception {
        String appIdCurrent = "&appid=bb9800b5d5cb9957043c1c7764bbf1c0";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=";
        JSONObject currentWeatherJson = new GetJsonObjectFromApi(url + "tallinn" + appIdCurrent).getJsonObject();
        int lenght = currentWeatherJson.length();
        assertEquals(12, lenght);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryFalseUrl() {
        GetJsonObjectFromApi jsonObjectOperator = new GetJsonObjectFromApi("ei url");
    }


}


