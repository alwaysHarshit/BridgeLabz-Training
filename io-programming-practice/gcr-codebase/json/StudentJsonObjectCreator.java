package json;

import org.json.JSONObject;

public class StudentJsonObjectCreator {
    public static JSONObject createStudentObject(String name, int age, String[]subjects){
        JSONObject studentObject = new JSONObject();
        studentObject.put("name", name);
        studentObject.put("age", age);
        studentObject.put("subjects",subjects);
        return studentObject;
    }

    public static void main(String[] args) {
        JSONObject student = createStudentObject("Ava", 21, new String[]{"Maths","Science","DBMS","Agile  development"});
        System.out.println("JSON object: ");
        System.out.println(student.toString());
    }
}
