package json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FilterJsonData {

    public static JSONArray getJsonObjectsFromFile(String fileName){

        JSONParser parser = new JSONParser();
        try(
            FileReader reader = new FileReader(fileName);
        ){
            Object parsedObject = parser.parse(reader);
            JSONArray userArray = (JSONArray) parsedObject;
            return userArray;
        }
        catch(IOException | ParseException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void filterUserData(){
        String fileName = "./src/main/java/json/User.json";
        JSONArray jsonArray = getJsonObjectsFromFile(fileName);
        if(jsonArray==null){
            return;
        }
        if(jsonArray.isEmpty()){
            System.out.println("No data found in the file.");
            return;
        }

        for(Object object: jsonArray){
            JSONObject jsonObject = (JSONObject)object;
            if(jsonObject.containsKey("age")){
                long age= (Long)jsonObject.get("age");
                if(age>25){
                    System.out.println(jsonObject.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        filterUserData();
    }
}
