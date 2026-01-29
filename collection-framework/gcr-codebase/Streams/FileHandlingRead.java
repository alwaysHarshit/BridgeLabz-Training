package java.Streams;
import java.io.*;

public class FileHandlingRead {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File destination = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
