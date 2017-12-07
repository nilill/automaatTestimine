package implementations;

import implementations.controller.Controler;
import implementations.dataOperations.GetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.json.JSONObject;

import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        WriteToFile filewriter = new WriteToFile();
        String city = "Tallinn";
        String appIdCurrent = "&appid=bb9800b5d5cb9957043c1c7764bbf1c0";
        String currentWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
        String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast?q=";

        JSONObject currentWeatherJson = new GetJsonObjectFromApi(currentWeatherUrl + city + appIdCurrent).getJsonObject();
        JSONObject forecastWeatherJson = new GetJsonObjectFromApi(forecastUrl + city + appIdCurrent).getJsonObject();

        Controler controler = new Controler(currentWeatherJson, forecastWeatherJson, filewriter);
        controler.setCity("Tallinn");
        String path = "D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\tests\\testTextFiles\\input.txt";
        controler.setCityFromFile(path);
        controler.saveDataToFile();

        System.out.println(controler.getCurrentWeather());
        System.out.println(controler.getForecastWeather());
    }

}
