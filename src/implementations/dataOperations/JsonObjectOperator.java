package implementations.dataOperations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

public class JsonObjectOperator {

    private JSONObject jObject;

    public JsonObjectOperator(String url) {
        StringBuilder sb = new StringBuilder();
        InputStream inStream = null;
        try {
            URL link = new URL(url);
            inStream = link.openStream();
            int i;
            byte[] buffer = new byte[8 * 1024];
            while ((i = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, i));
            }
            jObject = new JSONObject(sb.toString());
        } catch (Exception e) {
            e.getStackTrace();
            throw new IllegalArgumentException("Wrong url");
        }
    }

    public Double getDouble(String element) {
        return jObject.getDouble(element);
    }

    public Double getDoubleDepthTwo(String array, String sublist) {
        JSONObject geoObject = jObject.getJSONObject(array);
        return geoObject.getDouble(sublist);
    }

    public String getString(String element) {
        return jObject.getString(element);
    }

    String getStringDepthTwo(String list, String list2) {
        JSONObject geoObject = jObject.getJSONObject(list);
        return geoObject.getString(list2);
    }

    public JSONArray getListType() {
        return (JSONArray) jObject.get("list");
    }
}
