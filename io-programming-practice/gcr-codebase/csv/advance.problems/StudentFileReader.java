package csv_data_handling;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StudentFileReader {

    public static void readStudentFile() throws IOException , CsvValidationException{
        String filePath = "./src/main/java/csv_data_handling/Student.csv";
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] student;
            while((student = csvReader.readNext())!=null){
                System.out.printf("[ID: %s, Name: %s, Age: %s, Marks: %s]%n",student[0],student[1],student[2],student[3]);
            }
        }
    }
}
