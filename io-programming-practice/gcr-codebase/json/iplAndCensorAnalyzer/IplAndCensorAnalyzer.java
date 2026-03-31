package json.iplAndCensorAnalyzer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class IplAndCensorAnalyzer {
    
    private static boolean isCSVFile(String fileName){
        return fileName.endsWith(".csv");
    }

    private static boolean isJsonFile(String fileName){
        return fileName.endsWith(".json");
    }

    private static String outputFilePath(String filePath){

        String[] parts = filePath.split("/");
        String filename = parts[parts.length-1];
        String outputFilePath="./src/main/java/json/iplAndCensorAnalyzer/outputFiles/Censored"+filename;
        return outputFilePath;

    }

    private static void writeCsvFile(String filePath) throws IllegalArgumentException{
        String outputFilePath=outputFilePath(filePath);
        String []header = null;
        List<String[]> data = new ArrayList<>(); 
        try(
            FileReader fileReader = new FileReader(filePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ){
            String[] pointer;
            header = csvReader.readNext();
            if(header!=null){
                while((pointer = csvReader.readNext()) != null){
                    data.add(pointer);
                }
            }
        }
        catch(IOException e){
            throw new IllegalArgumentException("File not found");
        }
        catch(CsvValidationException e){
            throw new IllegalArgumentException("Invalid csv file");
        }
        
        try(
            FileWriter fileWriter = new FileWriter(outputFilePath);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
        ){
            if(header==null){
                throw new IllegalArgumentException("File data missing.");
            }
            csvWriter.writeNext(header);
            for(int i=0 ; i<header.length; i++){
                if(header[i].matches("[tT][eE][aA]m[1-9][0-9]*") || header[i].equalsIgnoreCase("winner")){
                    for(int j=0; j<data.size();j++){
                        try {
                            String teamName = data.get(j)[i];
                            String []teamParts= teamName.split("\\s+");
                            data.get(j)[i]=teamParts[0]+" ***";
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Invalid or missing team data");
                        }
                    }
                }
                else if(header[i].equalsIgnoreCase("player_of_match")){
                    for(int j=0; j<data.size();j++){
                        try {
                            data.get(j)[i]="REDACTED";
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Invalid or missing player name data");
                        }
                    }
                }
            }

            for(String[] d: data){
                csvWriter.writeNext(d);
            }
            System.out.println("Censored File created successfully");
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Error while writing the file. Error: "+e.getMessage());
        }
        
    }

    private static void writeJsonFile(String filePath) throws IllegalArgumentException{
        
    }

    public static void createCensoredFile(String filePath) throws IllegalArgumentException{

        if(isCSVFile(filePath)){
            writeCsvFile(filePath);
        }
        else if(isJsonFile(filePath)){
            writeJsonFile(filePath);
        }
        else{
            throw new IllegalArgumentException("Invalid file format");
        }
    }

    public static void main(String[] args) {
        String csvFilePath = "./src/main/java/json/iplAndCensorAnalyzer/resources/CSVInput.csv";
        createCensoredFile(csvFilePath);

    }
}
