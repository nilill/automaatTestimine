package implementations.controller;

import implementations.dataOperations.WriteToFile;
import implementations.reports.Coordinates;
import implementations.reports.CurrentWeather;
import implementations.reports.ForeCast;
import implementations.userInput.UserInputFromConsole;
import implementations.userInput.UserInputFromFile;
import interfaces.ControlerInterface;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Controler implements ControlerInterface {

    private BufferedReader br;
    private JSONObject currentWeatherJson;
    private JSONObject forecastWeatherJson;
    private String city = "Tallinn";
    private boolean streamedOutput = false;
    private WriteToFile fileWriter;

    public Controler(JSONObject currentWeatherJson, JSONObject forecastWeatherJson, WriteToFile writeToFile) {
        this.currentWeatherJson = currentWeatherJson;
        this.forecastWeatherJson = forecastWeatherJson;
        this.fileWriter = writeToFile;
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
        streamedOutput = false;
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
        return Coordinates.getCoordinates(currentWeatherJson);
    }

    public String getCurrentWeather() throws JSONException {
        return new CurrentWeather(currentWeatherJson).getCurrentWeather() + "°";
    }

    public String getForecastWeather() throws JSONException {
        return new ForeCast(forecastWeatherJson).getForecast();
    }

    public void saveDataToFile() throws JSONException {
        if (streamedOutput) {
            cityStream();
        } else {
            fileWriter.write(getCity() + "\n" +
                            getCoordinates() + "\n" +
                            "Current temperature: " + getCurrentWeather() + "\n" +
                            "Forecast: " + getForecastWeather(), city);
        }
    }

    private void cityStream() throws JSONException {
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

