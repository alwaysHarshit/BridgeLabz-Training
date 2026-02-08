package json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListOfJavaObjectsToJsonArrayConverter {

    //Conversion using org.json
    public static <T> JSONObject convertJavaObjectToJsonObject(T object){
        JSONObject jsonObject = new JSONObject();

        Class<?> classname = object.getClass();
        Field[] fields = classname.getDeclaredFields();

        for(Field field: fields){
            field.setAccessible(true);
            try {
                jsonObject.put(field.getName(), field.get(object));
            } 
            catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        return jsonObject;
    }

    public static <T> JSONArray convertListToJsonArray(List<T> list){
        JSONArray jsonArray = new JSONArray();

        for(T obj: list){
            JSONObject jsonObject = convertJavaObjectToJsonObject(obj);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
    
    public static void main(String[] args) {
        List<Person> personsList = new ArrayList<>();

        personsList.add(new Person("PID1", "Ava",21 ));
        personsList.add(new Person("PID2", "Lily", 22));
        personsList.add(new Person("PID3", "Violet", 23));
        personsList.add(new Person("PID14", "Bella", 24 ));

        JSONArray jsonArray = convertListToJsonArray(personsList);

        System.out.println(jsonArray.toString());
    }
}

class Person{
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}