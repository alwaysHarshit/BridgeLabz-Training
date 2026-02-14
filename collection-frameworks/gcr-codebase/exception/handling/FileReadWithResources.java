import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWithResources {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {

            String firstLine = reader.readLine();
            System.out.println("First line: " + firstLine);

        } catch (IOException e) {

            System.out.println("Error reading file");
        }
    }
}
