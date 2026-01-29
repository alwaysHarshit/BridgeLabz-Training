package java.Streams;
import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("Conversion complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
