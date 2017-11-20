package implementations.reports;

import implementations.dataOperations.JsonObjectOperator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CurrentWeather implements interfaces.CurrentWeatherInterface {

    private String url;

    public CurrentWeather(String URL) {
        this.url = URL;
    }

    @Override
    public String getCurrentWeather() {
        JsonObjectOperator jsonfile = new JsonObjectOperator(url);
        Double kelvin = jsonfile.getDoubleDepthTwo("main", "temp");
        Double celcsus = kelvin - 273.15;
        BigDecimal result = new BigDecimal(celcsus.toString());
        BigDecimal rounded = result.round(new MathContext(3, RoundingMode.HALF_UP));
        return rounded.toString();
    }
}
