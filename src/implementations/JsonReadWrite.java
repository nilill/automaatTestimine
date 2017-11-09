package implementations;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReadWrite {

    private JSONObject jObject;

    JsonReadWrite(String url) {
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
            throw new IllegalArgumentException("Wrong url");
        }

    }

    Double getDoubleDepthTwo(String array, String sublist) {
        JSONObject geoObject = jObject.getJSONObject(array);
        return geoObject.getDouble(sublist);
    }

    String getStringDepthTwo(String list, String list2) {
        JSONObject geoObject = jObject.getJSONObject(list);
        return geoObject.getString(list2);
    }

    String getStringDepthOne(String name) {
        return jObject.getString(name);
    }

    JSONArray getListType() {
        JSONArray jArray = (JSONArray) jObject.get("list");
        return jArray;
    }

    static void writeToFile(String text){
        Path path = Paths.get("D:\\Programeerimine\\Automaattestimine\\automaatTestimine", "info.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    static String readCityOutput(String path){
        if (!new File(path).exists()) {
            System.out.println("No such file, City set to default: Tallinn.");
            return null;
        } else {
            Path path1 = Paths.get(path);
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
                return reader.readLine();
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
