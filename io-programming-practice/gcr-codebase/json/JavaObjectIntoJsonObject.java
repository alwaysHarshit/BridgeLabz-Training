package json;

import java.lang.reflect.Field;

import org.json.JSONObject;

public class JavaObjectIntoJsonObject {
    
    public static JSONObject convertToJsonObject(Car car){

        try {
            JSONObject carObject = new JSONObject();

            Class<?> carClass = car.getClass();

            Field[] fields = carClass.getDeclaredFields();

            for(Field field: fields){
                field.setAccessible(true);
                String value = (String)field.get(car);
                carObject.put(field.getName(), value);
            }

            return carObject;

        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        JSONObject carJSONObject = convertToJsonObject(new Car("CAR123","BMW","Petrol"));
        System.out.println(carJSONObject.toString());
    }
}

class Car{

    private String carID;
    private String modelName;
    private String fuelType;

    public Car(String carID, String modelName, String fuelType) {
        this.carID = carID;
        this.modelName = modelName;
        this.fuelType = fuelType;
    }

    public String getCarID() {
        return carID;
    }

    public String getModelName() {
        return modelName;
    }

    public String getFuelType() {
        return fuelType;
    }

}
