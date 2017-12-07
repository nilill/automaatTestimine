package implementations.reports;

import implementations.dataOperations.GetDataTypesFromJsonObject;
import org.json.JSONObject;

public class Coordinates {

    public static String getCoordinates(JSONObject jsonObject) {

        double lon = GetDataTypesFromJsonObject.getDoubleDepthTwo("coord", "lon", jsonObject);
        double lat = GetDataTypesFromJsonObject.getDoubleDepthTwo("coord", "lat", jsonObject);
        boolean correctGeo = Validator.validateGEO(lon) && Validator.validateGEO(lat);
        return (correctGeo) ? "Coordinates: " + Double.toString(lon) + "/" + Double.toString(lat)
                : "No GEO coordinates are to be given";
    }
}
