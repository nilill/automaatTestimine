package implementations;

import implementations.controller.Controler;
import implementations.dataOperations.GetJsonObjectFromApi;
import implementations.dataOperations.WriteToFile;
import org.json.JSONObject;

public class main {
    public static void main(String[] args) {
        WriteToFile filewriter = new WriteToFile();
        String city = "Tallinn";
        String appIdCurrent = "&appid=bb9800b5d5cb9957043c1c7764bbf1c0";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=";
        String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast?q=";
        JSONObject currentWeatherJson = new GetJsonObjectFromApi(url + city + appIdCurrent).getJsonObject();
        JSONObject forecastWeatherJson = new GetJsonObjectFromApi(forecastUrl + city + appIdCurrent).getJsonObject();

        Controler controler = new Controler(currentWeatherJson, forecastWeatherJson, filewriter);
        controler.setCity("Tallinn");
        System.out.println(controler.getCurrentWeather());
        System.out.println(controler.getForecastWeather());
        System.out.println();
    }

}
