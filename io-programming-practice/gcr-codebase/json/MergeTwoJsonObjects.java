package json;

import org.json.JSONObject;

public class MergeTwoJsonObjects {

    public static JSONObject mergeJSONObject(JSONObject json1, JSONObject json2){
        JSONObject mergedJson = new JSONObject();
        for(String json1Key: json1.keySet()){
            mergedJson.put(json1Key,json1.get(json1Key));
        }
        for(String json2Key: json2.keySet()){
            mergedJson.put(json2Key,json2.get(json2Key));
        }
        return mergedJson;
    }
    
    public static void main(String[] args){
        JSONObject json1 = new JSONObject();
        json1.put("id","UID123");
        json1.put("name","Ava");
        json1.put("age",21);
        JSONObject json2 = new JSONObject();
        json2.put("email","ava@gmail.com");
        json2.put("course","B.Tech. CS");

        JSONObject mergedJson = mergeJSONObject(json1, json2);

        System.out.println("JSON Object 1: ");
        System.out.println(json1.toString());

        System.out.println("JSON Object 2: ");
        System.out.println(json2.toString());

        System.out.println("Merged JSON Object: ");
        System.out.println(mergedJson.toString());
        
    }
}
