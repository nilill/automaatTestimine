package implementations;

import interfaces.ControlerInterface;

import java.util.Scanner;

public class Controler implements ControlerInterface {
    private String city = "Tallinn";
    private String appIdCurrent = "&appid=bb9800b5d5cb9957043c1c7764bbf1c0";
    private String appIdForecast = "&appid=8ed7afa5f56fcd9ca49db9e458e97128&unit=metric";
    private String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast?q=\"";
    private String url = "http://api.openweathermap.org/data/2.5/weather?q=";
    @Override
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }



    @Override
    public String getCoordinates() {
        JsonReadWrite jsonfile =  new JsonReadWrite(url + city + appIdCurrent);
        return "Coordinates: " + jsonfile.getDoubleDepthTwo("coord", "lon").toString()
                + "/" + jsonfile.getDoubleDepthTwo("coord", "lat").toString();
    }

    String getCurrentWeather() {

        String statement = new CurrentWeather(url + city + appIdCurrent).getCurrentWeather();
        return this.getCity() + ": " + statement + " C";
    }

    String getForecastWeather() {
        return new ForeCast(forecastUrl + city + appIdCurrent).getMinMaxTemp(1);
    }
    void setCityFromFile(String path) {
        this.city = JsonReadWrite.readCityOutput(path);
        if (city == null) {
            city = "Tallinn";
        }
    }

    void setCityFromConsole() {
        System.out.println("Enter city: ");
        Scanner scanner = new Scanner(System.in);
        this.city = scanner.nextLine();
    }

    }

