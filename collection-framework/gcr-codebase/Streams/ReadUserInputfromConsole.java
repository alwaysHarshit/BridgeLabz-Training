package java.Streams;
import java.io.*;

public class ReadUserInputfromConsole {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("userinfo.txt")) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String lang = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + lang + "\n");

            System.out.println("Data saved to file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
