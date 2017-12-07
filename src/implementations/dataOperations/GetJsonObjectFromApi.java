package implementations.dataOperations;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

public class GetJsonObjectFromApi {

    JSONObject jsonObject;

    public  GetJsonObjectFromApi(String url) {

        StringBuilder sb = new StringBuilder();
        InputStream inStream = null;
        JSONObject jObject;
        try {
            URL link = new URL(url);
            inStream = link.openStream();
            int i;
            byte[] buffer = new byte[8 * 1024];
            while ((i = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, i));
            }
            jObject = new JSONObject(sb.toString());
            this.jsonObject = jObject;
            System.out.println(jObject.toString());
        } catch (Exception e) {
            e.getStackTrace();
            throw new IllegalArgumentException("Wrong url");
        }

    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}