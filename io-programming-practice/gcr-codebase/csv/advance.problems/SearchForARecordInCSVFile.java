package csv_data_handling;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class SearchForARecordInCSVFile {
    
    public static void searchRecordFromFile(String name)  throws IOException , CsvValidationException{
        String filePath = "./src/main/java/csv_data_handling/employees.csv";

        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            boolean employeeFound =false;
            String[] employee;

            employee = csvReader.readNext();

            if(employee!=null){
                while( (employee = csvReader.readNext()) != null){
                    try {
                        if(employee[1].equalsIgnoreCase(name)){
                            System.out.printf("Department: %s, Salary: %sINR%n",employee[2],employee[3]);
                            employeeFound=true;
                        }
                    } 
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("An Employee's data is missing");
                    }
                    if(employeeFound){
                        break;
                    }
                }
            }

            if(!employeeFound){
                System.out.println("No employee found with such name");
            }
        }
    }
}