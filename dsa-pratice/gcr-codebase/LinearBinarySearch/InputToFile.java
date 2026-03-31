package com.DSA.LinearBinarySearch;
import java.io.*;

public class InputToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line;
        System.out.println("Enter lines (type 'exit' to quit):");
        while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
        System.out.println("Written to file.");
    }
}
