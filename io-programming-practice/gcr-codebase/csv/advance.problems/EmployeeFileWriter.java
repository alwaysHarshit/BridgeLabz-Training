package csv_data_handling;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class EmployeeFileWriter {
    
    public static void writeEmployeeFile() throws IOException{
        String filePath = "./src/main/java/csv_data_handling/Employee.csv";

        try(
            FileWriter fileWriter = new FileWriter(filePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        ) {
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[][] employees = {{"EMP123","Ava" ,"IT" , "755000.00"},
                                    {"EMP456","Alice" ,"Finance" , "770000.00"},
                                    {"EMP789","Jennifer" ,"HR" , "655000.00"},
                                    {"EMP147","Lily" ,"Sales" , "685000.00"},
                                    {"EMP258","Violet" ,"Management" , "750000.00"}};
            
            csvWriter.writeNext(header);
            for(String[] employee: employees){
                csvWriter.writeNext(employee);
            }
            System.out.println("CSV file written successfully using OpenCSV!");

            
        }
    }
}
