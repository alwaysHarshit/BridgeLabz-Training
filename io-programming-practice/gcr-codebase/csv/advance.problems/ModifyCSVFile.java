package csv_data_handling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class ModifyCSVFile {
    
    public static void modifyCSVFile() throws IOException , CsvValidationException, NumberFormatException, ArrayIndexOutOfBoundsException{
        String filePath = "./src/main/java/csv_data_handling/employees.csv";

        List<String[]> newContent = new ArrayList<>();
        //Storing the modified content
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] employee;

            employee = csvReader.readNext();

            if(employee!=null){
                newContent.add(employee);
                while( (employee = csvReader.readNext()) != null){
                    
                    if(employee[2].equalsIgnoreCase("IT")){
                        double salary = Double.parseDouble(employee[3]);
                        salary += salary*0.1;
                        newContent.add(new String[]{employee[0],employee[1],employee[2],Double.toString(salary)});
                    }
                    else{
                        newContent.add(employee);
                    }
                }
            }

        }

        //Rewriting the file
        try(
            FileWriter fileWriter = new FileWriter(filePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        ){
            for(String[] newData : newContent){
                csvWriter.writeNext(newData);
            }
        }
    }
}
