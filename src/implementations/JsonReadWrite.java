package implementations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class JsonReadWrite {
    private String jsonstring;
    private JSONObject jObject;

    public JsonReadWrite(String url) {
        StringBuilder sb = new StringBuilder();
        InputStream inStream = null;
        try {
            URL link = new URL(url);
            inStream = link.openStream();
            int i;
            byte[] buffer = new byte[8 * 1024];
            while((i=inStream.read(buffer)) != -1)
            {
                sb.append(new String(buffer,0,i));
            }
        }
        catch(Exception e ) {
            System.out.println("Unhandled exception in programm code");
        }
        jsonstring = sb.toString();
        jObject = new JSONObject(sb.toString());
    }



    public Double getDoubleType(String arrayt) {
        return jObject.getDouble(arrayt);
    }

    public Double getDoubleType(String array, String sublist) {
        JSONObject geoObject = jObject.getJSONObject(array);
        return geoObject.getDouble(sublist);
    }

    public String getStringType(String list, String list2) {
        JSONObject geoObject = jObject.getJSONObject(list);
        return geoObject.getString(list2);
    }
    public String getStringType(String name) {
        return jObject.getString(name);
    }

    public String getListType(int day) {
        Double mintemp = Double.MAX_VALUE;
        Double maxtemp = Double.MIN_VALUE;
        boolean canMoveObjects = false;
        JSONArray jArray = (JSONArray)jObject.get("list");
        String dayWanted = LocalDate.now().plusDays(day).toString();

        if (jArray != null) {
            for (int i=0;i<jArray.length();i++){
                JSONObject elementInJSONarray = new JSONObject(jArray.get(i).toString());
                String dt_txt = elementInJSONarray.getString("dt_txt").substring(0, 10);
                if (dt_txt.equals(dayWanted)) {
                    canMoveObjects = true;
                }
                if (!dt_txt.equals(dayWanted)) {
                    canMoveObjects = false;
                }
                if (canMoveObjects) {
                    JSONObject first = new JSONObject(jArray.get(i).toString());
                    JSONObject main = new JSONObject(first.get("main").toString());
                    System.out.println(first);
                    System.out.println(main);
                    if (main.getDouble("temp_min") - 273.15 < mintemp) {
                        mintemp = main.getDouble("temp_min") - 273.15;
                    }
                    if (main.getDouble("temp_max") - 273.15 > maxtemp) {
                        maxtemp = main.getDouble("temp_max") - 273.15;
                    }
                }
            }
        }
        return mintemp.toString() + "/" + maxtemp.toString();
    }

}
