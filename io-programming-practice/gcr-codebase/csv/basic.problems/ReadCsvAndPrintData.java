package csv.basic.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class ReadCsvAndPrintData {

    //using standar bufferdreader and file reader
    static void method1(String datasetPath){

        try(BufferedReader bf=new BufferedReader(new FileReader(datasetPath))) {
            String line;
            while ((line= bf.readLine()) !=null){
                String[] split = line.split(",");
                System.out.println("ID: " + split[0] + ", Name: " + split[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //using nio reader
    static  void method2(String datasetPath){
        Path path = Path.of(datasetPath);

        try (Stream<String> lines = Files.lines(path)) {
            lines
                    .skip(1) // if first line is header, optional
                    .map(line -> line.split(","))
                    .forEach(parts ->
                            System.out.println("ID: " + parts[0] + ", Name: " + parts[1])
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        String datasetPath = "io-programming-practice/gcr-codebase/csv/basic.problems/Employees.csv";

        System.out.println("this is from method 1 \n");
        method1(datasetPath);

        System.out.println("this is from method 2 \n");
        method2(datasetPath);


    }
}
