package json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeTwoJsonObjectFiles {

    public static String mergeFiles(String fileName1, String fileName2) throws IOException{
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node1 = (ObjectNode) mapper.readTree(file1);
        ObjectNode node2 = (ObjectNode)mapper.readTree(file2);
        
        node1.setAll(node2);

        String objectData = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node1);
        return objectData;
        
    }

    public static void main(String[] args) {

        String fileName1 = "./src/main/java/json/Data1.json";
        String fileName2 = "./src/main/java/json/Data2.json";

        try {
            String merged = mergeFiles(fileName1, fileName2);
            System.out.println(merged);
        } 
        catch (IOException e) {
            System.out.println("Error while merging! Error: ");
        }


    }
}
