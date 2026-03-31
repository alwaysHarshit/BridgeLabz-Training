package csv_data_handling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class SortCSVRecordsByAColumn {
    
    public static void sortCSVRecordsByAColumn() throws IOException , CsvValidationException, NumberFormatException, ArrayIndexOutOfBoundsException{
        String filePath = "./src/main/java/csv_data_handling/employees.csv";

        String[] header = null;
        PriorityQueue< String[] > pq = new PriorityQueue<>((p,q)->{
            return Double.compare(Double.parseDouble(q[3]), Double.parseDouble(p[3]));
        });

        //Storing the modified content
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] employee;

            employee = csvReader.readNext();

            if(employee!=null){
                header = employee;

                while( (employee = csvReader.readNext()) != null){
                    pq.offer(employee);
                }
            }
        }

        //Rewriting the file
        try(
            FileWriter fileWriter = new FileWriter(filePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        ){
            csvWriter.writeNext(header);
            while(!pq.isEmpty()){
                csvWriter.writeNext(pq.poll());
            }
        }

        //Printing top 5 highest paid employees
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] employee;

            employee = csvReader.readNext();
            if(employee!=null){
                System.out.println(Arrays.toString(employee));
                int count=0;
                while( (employee = csvReader.readNext()) != null){
                    if(count==5){
                        break;
                    }
                    System.out.println(Arrays.toString(employee));
                    count++;
                }
            }
        }
    }
}
