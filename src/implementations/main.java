package implementations;

import org.json.JSONException;

public class main {
    public static void main(String[] args) throws JSONException {
        Controler controler = new Controler();
        System.out.println(controler.getCity());
        System.out.println(controler.getCurrentWeather());
        System.out.println(controler.getCoordinates());
        System.out.println(controler.getForecastWeather());

    }

}
