package csv_data_handling;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class ReadAndCountRowsInCSVFile {
    
    public static void readAndCountRowsInFile() throws IOException , CsvValidationException {
        String filePath = "./src/main/java/csv_data_handling/Product.csv";
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] pointer = csvReader.readNext();
            if(pointer!=null){
                System.out.print("|\t");
                for(String header: pointer){
                    System.out.print(header+"\t|\t");
                }
                int countRows = 0;
                while((pointer=csvReader.readNext())!=null){
                    System.out.print("\n|\t");
                    for(String data: pointer){
                        System.out.print(data+"\t|\t");
                    }
                    countRows++;
                }
                System.out.println("Number of rows: "+countRows);
            }

        }
    }
}
