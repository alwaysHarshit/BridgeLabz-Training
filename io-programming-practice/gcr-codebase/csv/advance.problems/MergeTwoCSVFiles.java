package csv_data_handling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class MergeTwoCSVFiles {

    public static void mergeFiles() throws IOException , CsvValidationException{

        Map<String, List<String>> studentsData = new LinkedHashMap<>();
        String filePath1 = "./src/main/java/csv_data_handling/students1.csv";
        try(
            FileReader fileReader = new FileReader(filePath1);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] student;
            boolean readHeader = false;
            while((student = csvReader.readNext())!=null){
                if(!readHeader){
                    readHeader=true;
                    continue;
                }
                List<String> data = new ArrayList<>();
                data.add(student[1]);
                data.add(student[2]);
                studentsData.put(student[0],data);
            }
        }
        String filePath2 = "./src/main/java/csv_data_handling/students2.csv";
        try(
            FileReader fileReader = new FileReader(filePath2);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] student;
            boolean readHeader = false;
            while((student = csvReader.readNext())!=null){
                if(!readHeader){
                    readHeader=true;
                    continue;
                }
                List<String> data = studentsData.get(student[0]);
                data.add(student[1]);
                data.add(student[2]);
            }
        }

        String mergedFilePath = "./src/main/java/csv_data_handling/MergedStudentsData.csv";
        try (
            FileWriter fileWriter = new FileWriter(mergedFilePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        ){
            csvWriter.writeNext(new String[]{"ID","Name","Age","Marks","Grade"});
            for(Map.Entry<String, List<String>> entry: studentsData.entrySet()){
                String[] student = new String[5];
                student[0]= entry.getKey();
                List<String> data = entry.getValue();
                for(int i=0; i<data.size() ; i++){
                    student[i+1]=data.get(i);
                }
                csvWriter.writeNext(student);
            }
            System.out.println("Data merged successfully");
        } 
    }
}
