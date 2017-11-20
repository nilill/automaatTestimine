package implementations.reports;

import implementations.dataOperations.JsonObjectOperator;

public class Coordinates {

    private static Validator validator = new Validator();

    public static String getCoordinates(String url) {
        JsonObjectOperator jsonfile =  new JsonObjectOperator(url);
        double lon = jsonfile.getDoubleDepthTwo("coord", "lon");
        double lat = jsonfile.getDoubleDepthTwo("coord", "lat");
        boolean correctGeo = Validator.validateGEO(lon) && Validator.validateGEO(lat);
        return (correctGeo) ? "Coordinates: " + Double.toString(lon) + "/" +  Double.toString(lat)
                : "No GEO coordinates are to be given";
    }
}
