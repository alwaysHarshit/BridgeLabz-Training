package json;

import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class ValidateUsingJsonSchema {
    
    public static boolean validateEmailField(String jsonString){
        String schemaString = """
                {
                    "$schema": "https://json-schema.org/draft/2020-12/schema",
                    "type": "object",
                    "properties":{
                        "name":{"type":"string"},
                        "email":{"type":"string", "format":"email"},
                        "age": {"type":"integer"}
                    },
                    "required":["name","email"]
                }
                """;

        ObjectMapper mapper = new ObjectMapper();

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        
        JsonSchema schema = factory.getSchema(schemaString);

        boolean isValid = false;
        try {
            Set<ValidationMessage> errors = schema.validate(mapper.readTree(jsonString));
            if(errors.isEmpty()){
                isValid=true;
            }
            else{
                for(ValidationMessage e: errors){
                    System.out.println(e.getMessage());
                }
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public static void main(String[] args) {
        String json1 = """
                        {
                            "name":"Ava",
                            "email": "ava@gmail.com",
                            "age":21
                        }
                        """;

        String json2 = """
                        {
                            "name":"Ava",
                            "email": "avagmailcom",
                            "age":21
                        }
                        """;

        String json3 = """
                        {
                            "email": "avagmailcom",
                            "age":21
                        }
                        """;

        System.out.println("Is JSON 1 Valid?: "+validateEmailField(json1));
        
        System.out.println("Is JSON 2 Valid?: "+validateEmailField(json2));
        
        System.out.println("Is JSON 3 Valid?: "+validateEmailField(json3));
    }

}
