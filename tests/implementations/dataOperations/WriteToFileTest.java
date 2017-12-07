package implementations.dataOperations;

import implementations.controller.Controler;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WriteToFileTest {
    private Controler controler;

    @Mock
    private
    WriteToFile writeToFile = mock(WriteToFile.class);

    @Before
    public void setup() {
        JSONObject current = MockGetJsonObjectFromApi.getCurrentWeatherJson();
        JSONObject forecast = MockGetJsonObjectFromApi.getForecastWeatherJson();
        this.controler = new Controler(current, forecast, writeToFile);

    }

    @Test
    public void testWriteToFileEachReportIsOnNewLine() {
        String currentWeather = controler.getCurrentWeather();
        String forecast = controler.getForecastWeather();
        String coordinates = controler.getCoordinates();
        writeToFile.write(currentWeather + "\n" + forecast + "\n" + coordinates, controler.getCity());
        verify(writeToFile).write("1.0°\n" +
                "Day 1)-0.°/2.0°   Day 2)4.0°/5.1°   Day 3)1.1°/4.3°   \n" +
                "Coordinates: 24.75/59.44", "Tallinn");
    }

}