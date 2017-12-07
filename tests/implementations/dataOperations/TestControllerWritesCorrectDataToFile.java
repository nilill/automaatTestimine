package implementations.dataOperations;

import implementations.controller.Controler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class TestControllerWritesCorrectDataToFile {
    private Controler controler;

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

    @Before
    public void setup() {
        GetJsonObjectFromApi current =  mock(GetJsonObjectFromApi.class);
        GetJsonObjectFromApi forecast = mock(GetJsonObjectFromApi.class);
        when((forecast).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getForecastWeatherJson());
        when((current).getJsonObject()).thenReturn(MockGetJsonObjectFromApi.getCurrentWeatherJson());
        this.controler = new Controler(current.getJsonObject(), forecast.getJsonObject(), writeToFile);
    }

    @Test
    public void testWriteToFileEachReportIsOnNewLine() {
        controler.setCity("Rakvere");
        controler.saveDataToFile();
        verify(writeToFile).write("Rakvere\n" +
                "Coordinates: 24.75/59.44\n" +
                "Current temperature: 1.0°\n" +
                "Forecast: Day 1)4.0°/5.1°   Day 2)1.1°/4.3°   Day 3)0.7°/3.2°   ", "Rakvere");
    }

}