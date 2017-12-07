package implementations.dataOperations;

import java.io.*;

public class WriteToFile {

    public void write(String text, String city) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\src\\textfiles\\" + city + ".txt"), "utf-8"))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
