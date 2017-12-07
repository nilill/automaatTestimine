package implementations.dataOperations;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetDataTypesFromJsonObject {

    static Double getDouble(String element, JSONObject jObject) {
        return jObject.getDouble(element);
    }

    public static Double getDoubleDepthTwo(String array, String sublist, JSONObject jObject) {
        JSONObject geoObject = jObject.getJSONObject(array);
        return geoObject.getDouble(sublist);
    }

    static String getStringDepthTwo(String list, String list2, JSONObject jObject) {
        JSONObject geoObject = jObject.getJSONObject(list);
        return geoObject.getString(list2);
    }

    public static JSONArray getListType(JSONObject jObject) {
        return (JSONArray) jObject.get("list");
    }
}
