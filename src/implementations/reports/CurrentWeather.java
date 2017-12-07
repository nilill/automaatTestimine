package implementations.reports;

import implementations.dataOperations.GetDataTypesFromJsonObject;
import org.json.JSONObject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CurrentWeather implements interfaces.CurrentWeatherInterface {

    private JSONObject jsonObject;

    public CurrentWeather(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public String getCurrentWeather() {

        Double kelvin = GetDataTypesFromJsonObject.getDoubleDepthTwo("main", "temp", jsonObject);
        Double celcsus = kelvin - 273.15;
        BigDecimal result = new BigDecimal(celcsus.toString());
        BigDecimal rounded = result.round(new MathContext(3, RoundingMode.HALF_UP));
        return rounded.toString();
    }
}
