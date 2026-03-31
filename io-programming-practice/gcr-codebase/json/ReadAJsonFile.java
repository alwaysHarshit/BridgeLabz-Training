package json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadAJsonFile {

    public static void readJSONFile(String fileName, String ...fieldsToRead){

        JSONParser parser = new JSONParser();
        try(
            FileReader reader = new FileReader(fileName);
        ){
            Object parsedObject = parser.parse(reader);

            JSONArray userArray = (JSONArray) parsedObject;

            for(Object object: userArray){
                JSONObject userObject = (JSONObject) object;

                StringBuilder userDetails = new StringBuilder();

                for(String field: fieldsToRead){
                    if(userObject.containsKey(field)){
                        String value = String.valueOf(userObject.get(field));
                        String detail = field+": "+value+",";
                        userDetails.append(detail);
                    }
                    else{
                        String detail = field+": *Missing field*,";
                        userDetails.append(detail);
                    }
                }
                System.out.println("["+(userDetails.isEmpty()?userObject.toString():userDetails.substring(0,userDetails.length()-1))+"]");
            }

        }
        catch(IOException | ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        String fileName = "./src/main/java/json/User.json";
        readJSONFile(fileName, "name", "email");
    }

}