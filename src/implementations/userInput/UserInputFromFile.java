package implementations.userInput;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInputFromFile {

    public static String getUserInput(final BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
