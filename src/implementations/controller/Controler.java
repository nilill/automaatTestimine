package implementations.controller;

import implementations.dataOperations.WriteToFile;
import implementations.reports.Coordinates;
import implementations.reports.CurrentWeather;
import implementations.reports.ForeCast;
import implementations.userInput.UserInputFromConsole;
import implementations.userInput.UserInputFromFile;
import interfaces.ControlerInterface;

import java.io.*;

public class Controler implements ControlerInterface {

    private BufferedReader br;

    private String city = "Tallinn";

    private String appIdCurrent = "&appid=bb9800b5d5cb9957043c1c7764bbf1c0";

    private String url = "http://api.openweathermap.org/data/2.5/weather?q=";

    private boolean streamedOutput = false;

    public Controler() {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\src\\textfiles\\input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityFromFile(String path) {
        streamedOutput = true;
        this.city = UserInputFromFile.getUserInput(br);
    }

    public void setCityFromConsole() {
        streamedOutput = false;
        this.city = UserInputFromConsole.getUserInput();
    }

    public String getCoordinates() {
        if (streamedOutput); // implement
        return Coordinates.getCoordinates(url + city + appIdCurrent);
    }

    public String getCurrentWeather() {
        if (streamedOutput); // implement
        String statement = new CurrentWeather(url + city + appIdCurrent).getCurrentWeather();
        return statement + "°";
    }

    public String getForecastWeather() {
        if (streamedOutput); // implement
        String forecastUrl = "https://api.openweathermap.org/data/2.5/forecast?q=";
        return new ForeCast(forecastUrl + city + appIdCurrent).getForecast(1);
    }

    public void saveDataToFile() {
        if (streamedOutput) {
            saveDataToFileStream();
        } else {
            WriteToFile.write(getCity() + "\n" +
                            getCoordinates() + "\n" +
                            "Current temperature: " + getCurrentWeather() + "\n" +
                            "Forecast: " + getForecastWeather()
                    , city);
        }
    }

    private void saveDataToFileStream() {
        String line = UserInputFromFile.getUserInput(this.br);
        while (line != null) {
            this.city = line;
            streamedOutput = false;
            saveDataToFile();
            streamedOutput = true;
            line = UserInputFromFile.getUserInput(this.br);
        }
    }
}

