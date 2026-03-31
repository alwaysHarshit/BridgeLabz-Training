package csv_data_handling;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class FilterRecordsFromCSV {
    
    public static void filterStudentMarks() throws IOException , CsvValidationException{

        String filePath = "./src/main/java/csv_data_handling/Student.csv";

        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] student;
            student = csvReader.readNext();
            if(student!=null){
                while((student=csvReader.readNext())!=null){
                    try {
                        int marks = Integer.parseInt(student[3]);
                        if( marks > 80){
                            System.out.printf("[ID: %s, Name: %s, Age: %s, Marks: %s]%n",student[0],student[1],student[2],student[3]);
                        }
                    } 
                    catch (NumberFormatException e) {
                        System.out.println("Invalid student marks.");
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Student marks data missing.");
                    }
                }
            }
        }
    }
    
}
