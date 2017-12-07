package implementations.userInput;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInputFromFile {

    public static String getUserInput(final BufferedReader bufferedReader){
        try {
            String city = bufferedReader.readLine();
            return city;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
