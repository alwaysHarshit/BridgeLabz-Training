package json;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonStructure {
    public static boolean validateJson(String json){
        boolean isValid = false;
        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readTree(json);
            isValid = true;
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public static void main(String[] args) {

        String json1="{\"userID\":\"wlw.ava\",\"name\":\"Ava\",\"age\":21}";
        boolean isValid1 = validateJson(json1);

        String json2 = "{\"userID\"}";
        boolean isValid2 = validateJson(json2);

        System.out.println("JSON 1: "+json1);
        System.out.println("Is valid?: "+isValid1);
        System.out.println();
        System.out.println("JSON 1: "+json2);
        System.out.println("Is valid?: "+isValid2);
    }
}
