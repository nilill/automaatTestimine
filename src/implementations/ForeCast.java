package implementations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class ForeCast implements interfaces.ForeCastInterface {
    private String url;
    private JsonReadWrite jsonReadWrite;

    ForeCast(String url) {
        this.url = url;
        jsonReadWrite = new JsonReadWrite(url);
    }

    public String getMinMaxTemp(int day) {
        JSONArray jArray = jsonReadWrite.getListType();
        Double mintemp = Double.MAX_VALUE;
        Double maxtemp = Double.MIN_VALUE;
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

                    if (main.getDouble("temp_min") - 273.15 < mintemp) {

                        mintemp = main.getDouble("temp_min") - 273.15;
                    }
                    if (main.getDouble("temp_max") - 273.15 > maxtemp) {

                        maxtemp = main.getDouble("temp_max") - 273.15;
                    }

                }
            }

        }
        BigDecimal min = new BigDecimal(mintemp).round(new MathContext(2));
        BigDecimal max = new BigDecimal(maxtemp).round(new MathContext(2));

        return "Min: " + min.toString().substring(0, 3) + "/Max: " + max.toString().substring(0, 3);
    }
}
