package json;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConvertor {
    
    public static String convertToXMLString( JSONObject jsonObject, String tagName ){
        return XML.toString(jsonObject,tagName);
    }

    public static void main(String[] args) {
        JSONObject personObject = new JSONObject();
        personObject.put("id","P1");
        personObject.put("name","Ava");
        personObject.put("age",21);

        String xmlString = convertToXMLString(personObject, "person");

        System.out.println(xmlString);
    }
}
