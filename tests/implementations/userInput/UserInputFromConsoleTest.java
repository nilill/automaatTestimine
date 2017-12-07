package implementations.userInput;

import implementations.controller.Controler;
import implementations.dataOperations.GetJsonObjectFromApi;
import implementations.dataOperations.MockGetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserInputFromConsoleTest {
    private Controler controler;

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);


    @Before
    public void setup() {
        GetJsonObjectFromApi current =  mock(GetJsonObjectFromApi.class);
        GetJsonObjectFromApi forecast = mock(GetJsonObjectFromApi.class);
        when((current).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getCurrentWeatherJson());
        when((forecast).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getForecastWeatherJson());
        this.controler = new Controler(current.getJsonObject(), forecast.getJsonObject(), writeToFile);
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