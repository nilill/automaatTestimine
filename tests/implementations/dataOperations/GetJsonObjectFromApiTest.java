package implementations.dataOperations;


import org.json.JSONObject;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GetJsonObjectFromApiTest {

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

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


