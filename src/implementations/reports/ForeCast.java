package implementations.reports;

import implementations.dataOperations.JsonObjectOperator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Objects;

public class ForeCast {
    private JsonObjectOperator jsonObjectOperator;

    public ForeCast(String url) {
        jsonObjectOperator = new JsonObjectOperator(url);
    }

    private String getMinMaxTemp(int day, String minOrMax) {
        JSONArray jArray = jsonObjectOperator.getListType();
        Double temp = (minOrMax.equals("temp_min")) ? Double.MAX_VALUE : Double.MIN_VALUE;
        boolean canMoveObjects;
        String dayWanted = LocalDate.now().plusDays(day).toString();
        if (jArray != null) {
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject elementInJSONarray = new JSONObject(jArray.get(i).toString());
                String dt_txt = elementInJSONarray.getString("dt_txt").substring(0, dayWanted.length());
                canMoveObjects = dt_txt.equals(dayWanted);
                if (canMoveObjects) {
                    JSONObject first = new JSONObject(jArray.get(i).toString());
                    JSONObject main = new JSONObject(first.get("main").toString());

                    if (Objects.equals(minOrMax, "temp_max") && main.getDouble(minOrMax) - 273.15 > temp) {
                        temp = main.getDouble(minOrMax) - 273.15;
                    }
                    if (Objects.equals(minOrMax, "temp_min") && main.getDouble(minOrMax) - 273.15 < temp) {
                        temp = main.getDouble(minOrMax) - 273.15;
                    }
                }
            }
        }
        BigDecimal minMax = new BigDecimal(temp).round(new MathContext(2));
        return minMax.toString().substring(0, 3);
    }

    public String getForecast(int day) {
        String result = "";
        for (int i = 1; i < 4; i++) {
            result += "Day " + i + ")" + stringBuilder(i) + "   ";
        }
        return result;
    }

    private String stringBuilder(int day) {
        String mintemp = getMinMaxTemp(day, "temp_min");
        String maxTemp = getMinMaxTemp(day, "temp_max");
        Boolean validTemp = Validator.validateTemp(mintemp) && Validator.validateTemp(maxTemp);
        return (validTemp) ? mintemp + "°/" + maxTemp + "°" : "No temperature data is available";
    }
}
