package json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;

public class ConvertCsvDataToJson {

    public static String convertCsvToJsonString(String csvFilePath) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode jsonArray = mapper.createArrayNode();
        String[] header = null; 
        List<String[]> csvData = new ArrayList<>();
        try(
            FileReader fileReader = new FileReader(csvFilePath);
            CSVReader csvReader = new CSVReader(fileReader);
        ) {
            
            header = csvReader.readNext();
            if(header!=null){
                String[] data;
                while((data=csvReader.readNext())!=null){
                    csvData.add(data);
                }
            }
            if(csvData.isEmpty()){
                System.out.println("No data found");
                return "";
            }           
        }
        for(String[] data: csvData){
            ObjectNode jsonObject = mapper.createObjectNode();
            for(int j=0; j<header.length; j++){
                jsonObject.put(header[j], data[j]);
            }
            jsonArray.add(jsonObject);
        }

        String jsonString = mapper
        .writeValueAsString(jsonArray);
        return jsonString;
        
    }
    public static void main(String[] args) {
        String csvFilePath = "./src/main/java/json/Student.csv";
        try {
            String jsonString = convertCsvToJsonString(csvFilePath);
            System.out.println(jsonString);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
