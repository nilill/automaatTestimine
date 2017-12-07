package implementations.dataOperations;

import implementations.controller.Controler;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetDataTypesFromJsonObjectTest {
    private Controler controler;
    JSONObject current;
    JSONObject forecast;


    @Before
    public void setUp() {
        current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, null);
    }

    @Test
    public void getDouble() throws Exception {
        Double dt = GetDataTypesFromJsonObject.getDouble("dt", current);
        assertEquals("1.5125682E9", dt.toString());
    }

    @Test
    public void getDoubleDepthTwo() throws Exception {
        Double kelvin = GetDataTypesFromJsonObject.getDoubleDepthTwo("main", "temp", current);
        assertEquals("274.15" , kelvin.toString());
    }

    @Test
    public void getStringDepthTwo() throws Exception {
        String string = GetDataTypesFromJsonObject.getStringDepthTwo("sys", "country", current);
        assertEquals("EE", string);
    }

    @Test
    public void getThatDataReturnerReturned40Readings() throws Exception {
        JSONArray jsonArray = GetDataTypesFromJsonObject.getListType(forecast);
        int len = jsonArray.length();
        assertEquals(40, len);
    }

}