package implementations.userInput;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class UserInputFromFileTest {
    @Test
    public void getUserInput() throws Exception {
        BufferedReader br;
        String city = null;
        try {
            br  = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\tests\\testTextFiles\\input.txt")));
            city = UserInputFromFile.getUserInput(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals("Narva", city);

    }

}