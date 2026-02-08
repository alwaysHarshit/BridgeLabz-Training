package csv.basic.problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsOfCsvFile {
    public static void main(String[] args) {
        String datasetPath = "io-programming-practice/gcr-codebase/csv/basic.problems/Employees.csv";

        try (BufferedReader bf=new BufferedReader(new FileReader(datasetPath))){
            int count=0;
            String line;
            boolean header=false;
            while ((line=bf.readLine())!=null ){
                if(!header){
                    header = true;
                    continue;
                }
                count++;
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
